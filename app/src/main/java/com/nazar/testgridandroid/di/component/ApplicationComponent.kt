package com.nazar.testgridandroid.di.component

import com.nazar.testgridandroid.MyApplication
import com.nazar.testgridandroid.di.module.ActivityBuilder
import com.nazar.testgridandroid.di.module.ApplicationModule
import com.nazar.testgridandroid.di.module.FragmentModule
import com.nazar.testgridandroid.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (AndroidSupportInjectionModule::class),
        (ApplicationModule::class),
        (ActivityBuilder::class),
        (FragmentModule::class),
        (NetworkModule::class)]
)
interface ApplicationComponent{

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication) : Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: MyApplication)
}
