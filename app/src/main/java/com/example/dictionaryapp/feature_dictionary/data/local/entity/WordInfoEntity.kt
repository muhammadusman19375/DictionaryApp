package com.example.dictionaryapp.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryapp.feature_dictionary.domain.model.License
import com.example.dictionaryapp.feature_dictionary.domain.model.Meaning
import com.example.dictionaryapp.feature_dictionary.domain.model.Phonetic
import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val license: License,
    val meanings: List<Meaning>,
    val phonetic: String,
    val phonetics: List<Phonetic>,
    val sourceUrls: List<String>,
    val word: String,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            license = license,
            meanings = meanings,
            phonetic = phonetic,
            phonetics = phonetics,
            sourceUrls = sourceUrls,
            word = word
        )
    }
}
