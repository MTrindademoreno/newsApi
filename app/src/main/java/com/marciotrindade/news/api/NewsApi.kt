package com.marciotrindade.news.api

import com.marciotrindade.news.api.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything?sortBy=popularity")
    suspend fun getNews(
        @Query("q")theme:String,
        @Query("from")data:String,
        @Query("language")language:String
    ):Response
}