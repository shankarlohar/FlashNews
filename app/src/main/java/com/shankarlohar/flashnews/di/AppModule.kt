package com.shankarlohar.flashnews.di

import com.shankarlohar.flashnews.BuildConfig
import com.shankarlohar.flashnews.models.ApiKey
import com.shankarlohar.flashnews.network.RetrofitApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun providesApiService() = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create()).build().create(RetrofitApiInterface::class.java)

    @Provides
    fun providesApiKey() = ApiKey(BuildConfig.API_KEY)
}