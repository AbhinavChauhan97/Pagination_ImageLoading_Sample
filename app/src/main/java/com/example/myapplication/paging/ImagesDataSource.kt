package com.example.myapplication.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.myapplication.api.ImageAPI
import com.example.myapplication.model.Image
import com.example.myapplication.repository.RetrofitClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ImagesDataSource : PageKeyedDataSource<Int, Image>() {

    private val imagesAPI = RetrofitClient.retrofit.create(ImageAPI::class.java)
    private var currentPage = 0
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Image>
    ) {
        GlobalScope.launch {
            val imagesResponse = imagesAPI.getImages(currentPage)
            val images = imagesResponse.body()!! // risk, improve later
           // Log.d("log", "load initial" + currentPage)
            callback.onResult(images,null,++currentPage)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Image>) {
       // Log.d("log","load before")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Image>) {
        //Log.d("log", "load after")
        GlobalScope.launch {
            val imageResponse = imagesAPI.getImages(params.key)
            val images = imageResponse.body()!! // risk

            var currentKey = params.key

            callback.onResult(images,++currentKey)
        }
    }
}