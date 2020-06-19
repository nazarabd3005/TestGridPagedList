package com.nazar.testgridandroid.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.nazar.testgridandroid.model.ImageItem
import com.nazar.testgridandroid.repo.ImageListRepository

class MainViewModel (private val repository: ImageListRepository) : ViewModel() {

    fun getImageList() : LiveData<PagedList<ImageItem>> {
        return repository.getImageList()
    }
}