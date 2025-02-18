package com.domain.acleda.domain

import com.domain.acleda.data.helper.util.Resource
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody

interface AppMainService
{
    fun onTestNetwork(): Flow<Resource<ResponseBody>>
}