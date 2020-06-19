package com.nazar.testgridandroid.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nazar.testgridandroid.repo.ImageListRepository
import com.nazar.testgridandroid.ui.MainViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val repository: ImageListRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(repository) as T
            else-> throw IllegalArgumentException("Unknown view model class ${modelClass.name}")
        }
    }

}