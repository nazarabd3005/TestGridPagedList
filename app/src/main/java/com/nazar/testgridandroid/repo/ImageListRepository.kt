package com.nazar.testgridandroid.repo

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.nazar.testgridandroid.datasource.ImageListDataSourceFactory
import com.nazar.testgridandroid.model.ImageItem
import com.nazar.testgridandroid.service.Service
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ImageListRepository @Inject constructor(
    private val service: Service
) {

    lateinit var newsList: LiveData<PagedList<ImageItem>>
    private val compositeDisposable = CompositeDisposable()
    private val pageSize = 20
    private var newsDataSourceFactory: ImageListDataSourceFactory? = null


    fun getImageList() : LiveData<PagedList<ImageItem>> {
        newsDataSourceFactory = ImageListDataSourceFactory(compositeDisposable, service)
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize / 2)
            .setEnablePlaceholders(false)
            .build()
        newsList = LivePagedListBuilder(newsDataSourceFactory!!, config).build()
        return newsList
    }
}