package com.example.apicall

import retrofit2.Call
import retrofit2.http.GET

interface Api_Interface {

    @GET("posts")

    fun getApiretrofit():Call<List<UserModelItem>>
}