package com.marciotrindade.news.home

import com.marciotrindade.news.News

class NewsBusiness {

    val repository by  lazy {
        NewsRepository()
    }

    suspend fun getNews(): ResponseApi {
        return repository.getNews()

    }
}