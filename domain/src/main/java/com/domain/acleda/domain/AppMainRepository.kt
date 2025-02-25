package com.domain.acleda.domain

import com.domain.acleda.data.helper.util.GenericResponse
import com.domain.acleda.data.helper.util.GenericSingleUseCase
import com.domain.acleda.data.helper.util.Resource
import com.domain.acleda.data.network.service.APIInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.ResponseBody
import javax.inject.Inject
import javax.inject.Named

class AppMainRepository @Inject constructor(@Named("port") private val api: APIInterface) : AppMainService
{
    override fun onTestNetwork(): Flow<Resource<ResponseBody>> = flow {
        try
        {
            when (val result = GenericResponse(GenericSingleUseCase(api.onGetUserInfo())).execute())
            {
                is Resource.Success ->
                {
                    emit(Resource.Success(data = result.data, statusCode = result.statusCode, message = result.message, rawUrl = result.rawUrl))
                }
                
                is Resource.Error ->
                {
                    emit(Resource.Error(data = result.data, statusCode = result.statusCode, message = result.message, rawUrl = result.rawUrl))
                }
            }
        }
        catch (e: Exception)
        {
            emit(Resource.Error(data = null, statusCode = "", message = e.message, rawUrl = "", throwable = e))
        }
    }
}