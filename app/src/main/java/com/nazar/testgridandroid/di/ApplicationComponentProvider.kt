package com.nazar.testgridandroid.di

import com.nazar.testgridandroid.di.component.ApplicationComponent

interface ApplicationComponentProvider {
    fun provideApplicationComponent() : ApplicationComponent
}