package com.example.myapplication.paging

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.Image
import javax.sql.DataSource

class ImagesDataSourceFactory : androidx.paging.DataSource.Factory<Int, Image>() {

    private val imagesLiveData = MutableLiveData<ImagesDataSource>()
    override fun create(): androidx.paging.DataSource<Int, Image> {
        val imagesDataSource = ImagesDataSource()
        imagesLiveData.postValue(imagesDataSource)
        return imagesDataSource
    }

}