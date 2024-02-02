package com.example.dictionaryapp.feature_dictionary.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.dictionaryapp.core.util.Resource
import com.example.dictionaryapp.feature_dictionary.data.local.WordInfoDao
import com.example.dictionaryapp.feature_dictionary.data.remote.DictionaryApi
import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo
import com.example.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfos = api.getWordInfo(word)
            remoteWordInfos.body()?.let { resList ->
                dao.deleteWordInfos(resList.map { it.word })
                dao.insertWordInfos(resList.map { it.toWordInfoEntity() })
            }
        } catch (e: Exception) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",
                    data = wordInfos
                )
            )
        }

        val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(data = newWordInfos))

    }
}