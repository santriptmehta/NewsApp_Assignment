package com.binarybeast.newsfog

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {

    @GET("v2/top-headlines")
    fun fetchHeadlines(@Query("country") country: String, @Query("category") category: String, @Query("apiKey") apiKey: String): Call<News>

    // https://newsapi.org/v2/top-headlines?country=in&apiKey=c81ad3c026fb400b98c43bc83f82a9d3
}