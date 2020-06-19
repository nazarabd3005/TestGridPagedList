package com.nazar.testgridandroid

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.nazar.testgridandroid.di.ApplicationComponentProvider
import com.nazar.testgridandroid.di.component.ApplicationComponent
import com.nazar.testgridandroid.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : Application(), ApplicationComponentProvider, HasAndroidInjector{

    private lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun provideApplicationComponent(): ApplicationComponent {
        return applicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .application(this)
            .build()
        applicationComponent.inject(this)

    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }


}