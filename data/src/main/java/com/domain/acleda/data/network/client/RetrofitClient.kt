package com.domain.acleda.data.network.client

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient
{
    private fun onOkHttpClientProvider(): OkHttpClient = OkHttpClient().newBuilder()
        .readTimeout(60L, TimeUnit.SECONDS)
        .connectTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(DefaultInterceptor())
        .build()
    
    fun onRetrofitBuilder(): Retrofit = Retrofit.Builder().baseUrl("/")
        .addConverterFactory(MoshiConverterFactory.create().asLenient())
        .client(onOkHttpClientProvider())
        .build()
}