package com.domain.acleda.data.network.area

import com.domain.acleda.data.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/** @author pha
 *  Class used for provide Area URL (uat or production)
 * */

@Module
@InstallIn(SingletonComponent::class)
class RequestAreaURL
{
    @Provides
    fun onGenerateBaseUrl(): String
    {
        return if (BuildConfig.IS_PRODUCTION) BuildConfig.URL_PRODUCTION else BuildConfig.URL_UAT
    }
}