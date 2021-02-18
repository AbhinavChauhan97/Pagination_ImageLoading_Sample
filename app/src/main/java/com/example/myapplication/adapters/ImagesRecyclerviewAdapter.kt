package com.example.myapplication.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RowImageBinding
import com.example.myapplication.model.Image

class ImagesRecyclerviewAdapter :
    PagedListAdapter<Image, ImagesRecyclerviewAdapter.ImageViewHolder>(DIFF_CALLBACK) {

    class ImageViewHolder(var binding: RowImageBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(image: Image) {
            if (!image.downloadUrl.endsWith("100/")) {
                image.downloadUrl = image.downloadUrl.dropLast(9) + "100/100/"
                Log.d("log", image.downloadUrl)
            }
            binding.imageData = image
            binding.executePendingBindings()
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Image>() {
            override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowImageBinding.inflate(layoutInflater, parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        //Log.d("log", "bind" + getItem(position)!!.id)
        holder.bind(getItem(position)!!) // risk
    }

}