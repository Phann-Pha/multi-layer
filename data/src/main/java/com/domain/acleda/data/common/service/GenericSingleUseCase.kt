package com.domain.acleda.data.common.service

import com.domain.acleda.data.common.helper.BuildSingleUseCase
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class GenericSingleUseCase<T>(private val response: Single<Response<T>>) : BuildSingleUseCase<Response<T>>()
{
    override fun buildSingleUseCase(): Single<Response<T>>
    {
        return response
    }
}