package com.nazar.testgridandroid.service

import com.nazar.testgridandroid.model.ImageResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {


    @GET("curated")
    fun getImageList(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): Single<ImageResponse>

}