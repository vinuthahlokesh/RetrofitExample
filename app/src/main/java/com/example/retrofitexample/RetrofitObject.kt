package com.example.retrofitexample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitObject {

    //Base url
    private val BASE_URL = "https://gorest.co.in/public-api/"

    //object of retrofit

    // val retrofit= Retrofit.Builder()
    //     .addConverterFactory(ScalarsConverterFactory.create())
    //   .baseUrl(BASE_URL)
    // .build()
  //  }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    fun getRetrofitInstance(): Retrofit {
        return retrofit
    }
    fun initialize(){
        retrofit
    }
}