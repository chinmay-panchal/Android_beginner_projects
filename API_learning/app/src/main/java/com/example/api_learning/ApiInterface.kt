package com.example.api_learning

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    fun getProductData(): Call<MyData>
}