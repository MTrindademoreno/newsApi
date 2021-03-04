package com.marciotrindade.news.home

sealed class ResponseApi {
    class Success(var result: Any?) : ResponseApi()
    class Error(var message:String):ResponseApi()

}