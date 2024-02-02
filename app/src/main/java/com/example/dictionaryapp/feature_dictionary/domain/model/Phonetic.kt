package com.example.dictionaryapp.feature_dictionary.domain.model

data class Phonetic(
    val audio: String,
    val license: License,
    val sourceUrl: String,
    val text: String
)