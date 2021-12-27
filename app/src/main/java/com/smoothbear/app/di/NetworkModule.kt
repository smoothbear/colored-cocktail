package com.smoothbear.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.smoothbear.app.network.CocktailService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("http://localhost:8080")
        .build()

    @Provides
    @Singleton
    fun provideCocktailService(retrofit: Retrofit) = retrofit.create(CocktailService::class.java)

}