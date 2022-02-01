package com.example.jetpackproject.di

import com.example.jetpackproject.rest.AuthInterceptor
import com.example.jetpackproject.ui.ApiProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val BASE_URL = "https://cardano-mainnet.blockfrost.io/api/v0/"

    @Singleton
    @Provides
    fun provideApiProvider(retrofit: Retrofit): ApiProvider = retrofit.create(ApiProvider::class.java)

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun providesAuthInterceptor() : AuthInterceptor = AuthInterceptor()

    @Singleton
    @Provides
    fun providesOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(authInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(gsonConverterFactory)
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

}