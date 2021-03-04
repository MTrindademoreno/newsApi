package com.marciotrindade.news.api.model

data class Response(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)