package com.nazar.testgridandroid.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nazar.testgridandroid.ui.MainAdapter

object CustomViewBinding {


    @BindingAdapter("setAdapter")
    @JvmStatic
    fun bindRecylerViewAdapter(recyclerView: RecyclerView, adapter: DataBindingAdapter<*>){
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, 3)
        recyclerView.adapter = adapter
    }

    @BindingAdapter("profileImage")
    @JvmStatic
    fun bindLoadImage(view: ImageView, imageUrl: String) {
        Glide.with(view.context)
            .load(imageUrl)
            .into(view);
    }
}

