package com.nazar.feature.logs.service

import com.nazar.feature.logs.domain.models.LogModel
import com.nazar.feature.logs.entity.LogEntity


// TODO Not required now to avoid bloating with complexity
interface LogService {

    suspend fun storeLog(logModel: LogModel):Boolean // Return Status Code

    suspend fun queryLog(searchString:String):List<LogModel>
}