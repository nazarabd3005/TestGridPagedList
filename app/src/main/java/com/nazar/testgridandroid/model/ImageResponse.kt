package com.nazar.testgridandroid.model

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("total_results")
    val totalResults: Long,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("photos")
    val photos: ArrayList<ImageItem>
)