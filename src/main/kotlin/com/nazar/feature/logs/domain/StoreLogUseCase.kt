package com.nazar.feature.logs.domain

import com.nazar.base.BaseResponse
import com.nazar.base.BaseUseCase
import com.nazar.base.FailureResponse
import com.nazar.base.SuccessResponse
import com.nazar.feature.logs.domain.models.LogModel
import com.nazar.feature.logs.entity.LogEntity
import com.nazar.feature.logs.request.LogRequest
import com.nazar.feature.logs.service.LogService
import io.ktor.http.*

class StoreLogUseCase(private val logservice:LogService):BaseUseCase<LogRequest, Boolean> {
    override suspend fun invoke(input: LogRequest): BaseResponse<Boolean> {

        val isSuccess= logservice.storeLog(LogModel(tag= input.tag, logMessage = input.log))
        return if(isSuccess)
            SuccessResponse(HttpStatusCode.OK.value)
        else
            FailureResponse(HttpStatusCode.InternalServerError.value)


    }


}