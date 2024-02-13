package com.nazar.feature.logs.domain

import com.nazar.base.BaseResponse
import com.nazar.base.BaseUseCase
import com.nazar.base.SuccessResponse
import com.nazar.feature.logs.domain.models.LogModel
import com.nazar.feature.logs.request.QueryLogsRequest
import com.nazar.feature.logs.service.LogService
import io.ktor.http.*

class FetchLogsUseCase(val logService: LogService) : BaseUseCase<QueryLogsRequest, List<LogModel>> {
    override suspend fun invoke(input: QueryLogsRequest): BaseResponse<List<LogModel>> {
        var resp = logService.queryLog(input.query)
        print(resp)
        return SuccessResponse(HttpStatusCode.OK.value, resp)

    }
}
