package com.marciotrindade.news.api

import com.marciotrindade.news.Constants.Api.API_KEY
import com.marciotrindade.news.Constants.Api.API_KEY_VALUE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {

    val newsApi = getNewsApi().create(NewsApi::class.java)

    private fun getNewsApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .client(getInterceptorClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    private fun getInterceptorClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    //.addHeader("q", "android")
                   // .addHeader("from", "2021-03-04")
                   // .addHeader("sortBy", "popularity")
                    .addHeader(API_KEY, API_KEY_VALUE)

                    .build()
                chain.proceed(newRequest)
            }

        return interceptor.build()
    }
}