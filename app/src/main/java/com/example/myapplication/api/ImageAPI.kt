package com.example.myapplication.api

import com.example.myapplication.model.Image
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageAPI {

    @GET("list/")
    suspend fun getImages(@Query("page") page:Int):Response<List<Image>>

    @GET("{id}/100/100")
    suspend fun getImage(id:Int):Response<Image>
}