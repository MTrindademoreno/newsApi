package com.marciotrindade.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marciotrindade.news.api.model.Article
import com.marciotrindade.news.api.model.Response
import com.marciotrindade.news.home.NewsBusiness
import com.marciotrindade.news.home.NewsRepository
import com.marciotrindade.news.home.ResponseApi
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val business = NewsBusiness()
    private var newsLiveData: MutableLiveData<List<News>> = MutableLiveData()
    var articlesMutableLive:MutableLiveData<Response> = MutableLiveData()

    fun getNews() {
        viewModelScope.launch {
when(val response =  business.getNews() ){
    is ResponseApi.Success->{
        articlesMutableLive.postValue(
            response.result as Response?
        )
    }
    is ResponseApi.Error->{


    }

}

        }
    }

}