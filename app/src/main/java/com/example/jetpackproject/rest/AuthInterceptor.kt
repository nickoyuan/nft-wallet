package com.example.jetpackproject.rest

import android.content.Context
import com.example.jetpackproject.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/***
 * Fortunately, Retrofit uses Okhttp through which we can add interceptors to our retrofit client.
 * Retrofit triggers the Interceptor instance whenever a request is made.
 */
class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        val apiKey = BuildConfig.API_KEY
        requestBuilder.addHeader("project_id", apiKey)
        return chain.proceed(requestBuilder.build())
    }
}