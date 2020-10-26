package com.example.retrofitexample

import retrofit2.Call
import retrofit2.http.GET



interface RetrofitInterface {
   @GET ("/public-api/posts")
   fun getdata (): Call<List<DataClass>>
}

