package com.domain.acleda.data.helper.util

import com.domain.acleda.data.helper.usecase.BuildSingleUseCase
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class GenericSingleUseCase<T>(private val response: Single<Response<T>>) : BuildSingleUseCase<Response<T>>()
{
    override fun buildSingleUseCase(): Single<Response<T>>
    {
        return response
    }
}