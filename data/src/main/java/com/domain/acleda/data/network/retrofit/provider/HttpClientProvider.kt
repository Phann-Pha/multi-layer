package com.domain.acleda.data.network.retrofit.provider

import com.domain.acleda.data.network.interceptor.DefaultInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/** @author pha
 *  Class used for provide OkHttpClient
 *  This class we create for provide all OkHttpClient that have different interceptor
 * */

@Module
@InstallIn(SingletonComponent::class)
class HttpClientProvider
{
    @Provides
    fun onOkHttpClientProvider(): OkHttpClient = OkHttpClient().newBuilder()
        .readTimeout(60L, TimeUnit.SECONDS)
        .connectTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(DefaultInterceptor())
        .build()
}