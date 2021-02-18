package com.example.myapplication.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.example.myapplication.R


object ImageBindingAdapter {

    @JvmStatic
    @BindingAdapter("image")
    fun setSrc(imageView: ImageView,url:String?){
        if(url != null) {
            imageView.load(url) {
                placeholder(R.drawable.ic_baseline_theaters_24)
            }
        }
    }
}