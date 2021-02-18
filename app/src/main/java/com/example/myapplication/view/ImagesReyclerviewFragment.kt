package com.example.myapplication.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.ImagesRecyclerviewAdapter
import com.example.myapplication.viewmodel.ImagesViewModel

class ImagesReyclerviewFragment : Fragment(R.layout.fragment_images_recyclerview) {

    lateinit var viewModel:ImagesViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ImagesViewModel::class.java)
        setupRecyclerView()
    }
    private fun setupRecyclerView(){
        val imagesRecyclerview = view!!.findViewById<RecyclerView>(R.id.images_recyclerview) // we are sure this id exits
        imagesRecyclerview.apply {
            addItemDecoration(DividerItemDecoration(requireActivity(),LinearLayoutManager.HORIZONTAL))
            addItemDecoration(DividerItemDecoration(requireActivity(),LinearLayoutManager.VERTICAL))
            layoutManager = GridLayoutManager(requireActivity(),2)

            setHasFixedSize(true)
        }
        val imagesAdapter = ImagesRecyclerviewAdapter()
        viewModel.imagesLiveData.observe(requireActivity()){
              imagesAdapter.submitList(it)
        }
        imagesRecyclerview.adapter  = imagesAdapter
    }
}