package com.kiran.daggerpoc.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kiran.data.network.BlogAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideOkHttp() = OkHttpClient.Builder().run {
        connectTimeout(15, TimeUnit.SECONDS)
        readTimeout(15, TimeUnit.SECONDS)
        callTimeout(15, TimeUnit.SECONDS)
        //TODO: Check for Debug and add -> if (BuildConfig.DEBUG) { .. }
        addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        return@run build()
    }

    @Provides
    @Singleton
    fun providesBlogAPI(
        httpClient: OkHttpClient,
        gson:  Gson
    ): BlogAPI = providesRetrofit(httpClient,
        "https://open-api.xyz/placeholder/", gson)
        .create(BlogAPI::class.java)

    private fun providesRetrofit(
        httpClient: OkHttpClient,
        baseUrl: String,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}