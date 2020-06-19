package com.nazar.testgridandroid.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nazar.testgridandroid.di.scope.ApiKey
import com.nazar.testgridandroid.di.scope.BaseUrl
import com.nazar.testgridandroid.service.Service
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideGson(): Gson {
        val builder = GsonBuilder()
        return builder.create()
    }

    @Singleton
    @Provides
    fun provideClient(@ApiKey apiKey: String) : OkHttpClient.Builder{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(object : Interceptor{
                override fun intercept(chain: Interceptor.Chain): Response {
                    val original: Request = chain.request()

                    val request: Request = original.newBuilder()
                        .header("Authorization", apiKey)
                        .method(original.method, original.body)
                        .build()

                    return chain.proceed(request)
                }
            })
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, @BaseUrl baseUrl: String,client: OkHttpClient.Builder): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit) : Service {
        return retrofit.create(Service::class.java)
    }
}