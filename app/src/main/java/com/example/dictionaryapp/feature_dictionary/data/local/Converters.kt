package com.example.dictionaryapp.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionaryapp.feature_dictionary.data.util.JsonParser
import com.example.dictionaryapp.feature_dictionary.domain.model.Definition
import com.example.dictionaryapp.feature_dictionary.domain.model.License
import com.example.dictionaryapp.feature_dictionary.domain.model.Meaning
import com.example.dictionaryapp.feature_dictionary.domain.model.Phonetic
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json = json,
            type = object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            obj = meanings,
            type = object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromStringJson(json: String): List<String> {
        return jsonParser.fromJson<ArrayList<String>>(
            json = json,
            type = object : TypeToken<ArrayList<String>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toStringJson(string: List<String>): String {
        return jsonParser.toJson(
            obj = string,
            type = object : TypeToken<ArrayList<String>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromPhoneticsJson(json: String): List<Phonetic> {
        return jsonParser.fromJson<ArrayList<Phonetic>>(
            json = json,
            type = object : TypeToken<ArrayList<Phonetic>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toPhoneticsJson(phonetic: List<Phonetic>): String {
        return jsonParser.toJson(
            obj = phonetic,
            type = object : TypeToken<ArrayList<Phonetic>>() {}.type
        ) ?: "[]"
    }
//
//    @TypeConverter
//    fun fromDefinitionsJson(json: String): List<Definition> {
//        return jsonParser.fromJson<ArrayList<Definition>>(
//            json = json,
//            type = object : TypeToken<ArrayList<Definition>>() {}.type
//        ) ?: emptyList()
//    }
//
//    @TypeConverter
//    fun toDefinitionsJson(definition: List<Definition>): String {
//        return jsonParser.toJson(
//            obj = definition,
//            type = object : TypeToken<ArrayList<Definition>>() {}.type
//        ) ?: "[]"
//    }
//
    @TypeConverter
    fun fromLicenseJson(json: String): License {
        return jsonParser.fromJson<License>(
            json = json,
            type = object : TypeToken<License>() {}.type
        ) ?: License("", "")
    }

    @TypeConverter
    fun toLicenseJson(license: License): String {
        return jsonParser.toJson(
            obj = license,
            type = object : TypeToken<License>() {}.type
        ) ?: ""
    }
}