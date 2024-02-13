package com.nazar.feature.logs.repository

import com.nazar.feature.logs.entity.LogEntity

interface LogRepository {

    suspend fun storeLog(logEntity: LogEntity):Boolean // Return Status Code

    suspend fun queryLog(searchString:String):List<LogEntity>
}
