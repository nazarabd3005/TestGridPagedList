package com.nazar.testgridandroid.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nazar.testgridandroid.model.ImageItem
import com.nazar.testgridandroid.service.Service
import io.reactivex.disposables.CompositeDisposable

class ImageListDataSourceFactory(
    private val compositeDisposable: CompositeDisposable,
    private val service: Service
): DataSource.Factory<Int, ImageItem>() {

    private val newsDataSourceLiveData = MutableLiveData<ImageListDataSource>()

    override fun create(): DataSource<Int, ImageItem> {
        val newsDataSource = ImageListDataSource(service, compositeDisposable)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }

    public fun getLiveData(): MutableLiveData<ImageListDataSource> = newsDataSourceLiveData
}