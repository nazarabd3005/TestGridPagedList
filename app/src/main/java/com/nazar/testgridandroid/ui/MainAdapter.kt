package com.nazar.testgridandroid.ui

import com.nazar.testgridandroid.R
import com.nazar.testgridandroid.model.ImageItem
import com.nazar.testgridandroid.util.DataBindingAdapter

class MainAdapter : DataBindingAdapter<ImageItem>(MainDiffCalback()) {
    override fun getItemViewType(position: Int): Int = R.layout.layout_image_list
}