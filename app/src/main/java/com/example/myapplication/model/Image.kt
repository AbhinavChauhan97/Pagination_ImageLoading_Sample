package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class Image(
    val id:Int,
    val author:String,
    val url:String,

    @SerializedName("download_url")
    var downloadUrl:String,
    val width:Int,
    val height:Int,
)
