package com.domain.acleda.data.common.service

import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class GenericResponse<T>(private val genericSingleUseCase: GenericSingleUseCase<T>)
{
    suspend fun execute(): Resource<T>
    {
        return suspendCoroutine { continuation ->
            try
            {
                genericSingleUseCase.execute(
                    success = { response ->
                        continuation.resume(Resource.Success(data = response.body(), statusCode = response.code().toString(), message = response.message(), rawUrl = response.raw().request().url().toString()))
                    },
                    error = { throwable ->
                        continuation.resume(Resource.Error(message = throwable.message, throwable = throwable))
                    }
                )
            }
            catch (throwable: Throwable)
            {
                continuation.resume(Resource.Error(message = throwable.message, throwable = throwable))
            }
        }
    }
    
    suspend fun execute2(): Resource<Response<T>>
    {
        return suspendCoroutine { continuation ->
            try
            {
                genericSingleUseCase.execute(
                    success = { response ->
                        continuation.resume(Resource.Success(data = response, statusCode = response.code().toString(), message = response.message(), rawUrl = response.raw().request().url().toString()))
                    },
                    error = { throwable ->
                        continuation.resume(Resource.Error(message = throwable.message, throwable = throwable))
                    }
                )
            }
            catch (throwable: Throwable)
            {
                continuation.resume(Resource.Error(message = throwable.message, throwable = throwable))
            }
        }
    }
}