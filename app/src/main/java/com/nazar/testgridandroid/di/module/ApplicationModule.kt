package com.nazar.testgridandroid.di.module

import com.nazar.testgridandroid.di.scope.ApiKey
import com.nazar.testgridandroid.di.scope.BaseUrl
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    @BaseUrl
    fun provideBaseUrl(): String {
        return "https://api.pexels.com/v1/"
    }

    @Provides
    @ApiKey
    fun provideApiKey(): String {
        return "563492ad6f91700001000001e675431657eb4802940d6372c36e0471"
    }

}