package com.example.myapplication.repository

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val interceptor  = HttpLoggingInterceptor().apply {
       setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    val retrofit  = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://picsum.photos/v2/")
        .client(client)
        .build()
}