package com.farouk.inova_taskk.di

import android.content.Context
import com.farouk.inova_taskk.common.Constants
import com.farouk.inova_taskk.data.repository.RepoImp
import com.farouk.inova_taskk.domin.repository.RepoInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepo(context: Context): RepoInterface {
        return RepoImp(context)
    }
}