package com.binarybeast.newsfog

import com.binarybeast.newsfog.Constant.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NewsService {

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val newsInstance: NewsInterface = retrofit.create(NewsInterface::class.java)

}