package com.domain.acleda.data.network.retrofit.builder

import com.domain.acleda.data.network.area.RequestAreaURL
import com.domain.acleda.data.network.retrofit.provider.HttpClientProvider
import com.domain.acleda.data.network.service.APIInterface
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Named

/** @author pha
 *  Class used for provide retrofit builder
 *  This class we create for provide all retrofit builder that have different baseUrl
 *  @property clientProvider used for provide OkHttpClient (note don't used private access modifier, when used @Inject)
 *  @property area used for provide specific area url (note don't used private access modifier, when used @Inject)
 * */

@Module
@InstallIn(SingletonComponent::class)
class RetrofitBuilder @Inject constructor()
{
    internal val clientProvider: HttpClientProvider
        @Inject get() = HttpClientProvider()
    
    internal val area: RequestAreaURL
        @Inject get() = RequestAreaURL()
    
    @Provides
    @Named("builder")
    fun onRetrofitBuilder2(): Retrofit = Retrofit.Builder().baseUrl(area.onGenerateBaseUrl())
        .addConverterFactory(MoshiConverterFactory.create().asLenient())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(clientProvider.onOkHttpClientProvider())
        .build()
    
    @Provides
    @Named("port")
    fun onRetrofit(@Named("builder") retrofit: Retrofit): APIInterface = retrofit.create(APIInterface::class.java)
}