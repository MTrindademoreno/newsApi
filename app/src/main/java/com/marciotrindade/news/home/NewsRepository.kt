package com.marciotrindade.news.home

import com.marciotrindade.news.api.ApiService

class NewsRepository{

    suspend fun getNews():ResponseApi{

        return try {
            val response = ApiService.newsApi.getNews("Android","2021-03-04","pt")
             if(response.status == "ok"){
                ResponseApi.Success(response)
            }else{ResponseApi.Error("Erro Ao carregar Dados!")}



        }catch (exception:Exception){
             ResponseApi.Error("Erro ao carregar dados !!")
        }


//        var list = listOf(News("https://hackaday.com/wp-content/uploads/2021/02/bitcoin-energy-usage-featured.jpg",
//        "Titulo 1", "nononononoonono onononononono nononononono nononononon "),
//            News("https://hackaday.com/wp-content/uploads/2021/02/bitcoin-energy-usage-featured.jpg","Titulo 2",
//            "ououououououo uouououo ououououo ouououou ouououoo ouououo ouououou ouuououo"),
//            News("https://hackaday.com/wp-content/uploads/2021/02/bitcoin-energy-usage-featured.jpg",
//                "Titulo 1", "nononononoonono onononononono nononononono nononononon "),
//            News("https://hackaday.com/wp-content/uploads/2021/02/bitcoin-energy-usage-featured.jpg",
//                "Titulo 1", "nononononoonono onononononono nononononono nononononon "),
//            News("https://hackaday.com/wp-content/uploads/2021/02/bitcoin-energy-usage-featured.jpg",
//                "Titulo 1", "nononononoonono onononononono nononononono nononononon ")
//        )






    }

}