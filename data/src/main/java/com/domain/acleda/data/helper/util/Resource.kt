package com.domain.acleda.data.helper.util

sealed class Resource<T>(
    val data: T? = null,
    val statusCode: String? = "",
    val message: String? = "",
    val rawUrl: String? = "",
    val throwable: Throwable? = null
)
{
    class Success<T>(
        data: T? = null,
        statusCode: String? = "",
        message: String? = "",
        rawUrl: String? = "",
        throwable: Throwable? = null
    ) : Resource<T>(
        data = data,
        statusCode = statusCode,
        message = message,
        rawUrl = rawUrl,
        throwable = throwable
    )
    
    class Error<T>(
        data: T? = null,
        statusCode: String? = "",
        message: String? = "",
        rawUrl: String? = "",
        throwable: Throwable? = null
    ) : Resource<T>(
        data = data,
        statusCode = statusCode,
        message = message,
        rawUrl = rawUrl,
        throwable = throwable
    )
}