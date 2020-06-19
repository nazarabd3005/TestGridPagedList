package com.nazar.testgridandroid.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName

data class ImageItem(
    @SerializedName("id")
    val id: Long,
    @SerializedName("width")

    val width: Int,
    @SerializedName("height")

    val height: Int,
    @SerializedName("url")

    val url: String,
    @SerializedName("photographer")

    val photographer: String,
    @SerializedName("photographer_url")
    val photographerUrl: String,

    @SerializedName("photographer_id")
    val photographerId: Long,

    @SerializedName("liked")
    val liked: Boolean,

    @SerializedName("src")
    val src: Src
)

data class Src(
    @SerializedName("medium")
    val medium: String
)

