package com.nazar.testgridandroid.di.module

import com.nazar.testgridandroid.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindActivityMain() : MainActivity
}