package com.example.myapplication.viewmodel

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.myapplication.paging.ImagesDataSourceFactory

class ImagesViewModel : ViewModel() {

    lateinit var imagesLiveData:LiveData<PagedList<com.example.myapplication.model.Image>>

    init {
        val pagedListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setPrefetchDistance(20)
            .build()
        imagesLiveData = LivePagedListBuilder(ImagesDataSourceFactory(),pagedListConfig)
            .setInitialLoadKey(0)
            .build()
    }


}