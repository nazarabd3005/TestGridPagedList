package com.nazar.testgridandroid.ui

import androidx.recyclerview.widget.DiffUtil
import com.nazar.testgridandroid.model.ImageItem

class MainDiffCalback : DiffUtil.ItemCallback<ImageItem>() {
    override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
        return oldItem.src.medium == newItem.src.medium
    }

    override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
        return oldItem == newItem
    }

}