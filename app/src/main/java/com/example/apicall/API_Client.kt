package com.example.apicall

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API_Client {

    companion object {


    var base_url = "https://jsonplaceholder.typicode.com/"
    var retrofit: Retrofit? = null

    fun getretrofit():Retrofit {


            retrofit = Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        return retrofit as Retrofit
    }

    }

}