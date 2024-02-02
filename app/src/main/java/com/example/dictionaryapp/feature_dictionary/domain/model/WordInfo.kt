package com.example.dictionaryapp.feature_dictionary.domain.model

data class WordInfo(
    val license: License,
    val meanings: List<Meaning>,
    val phonetic: String,
    val phonetics: List<Phonetic>,
    val sourceUrls: List<String>,
    val word: String
)