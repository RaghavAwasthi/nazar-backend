package com.nazar.feature.logs.service

import com.nazar.feature.logs.domain.models.LogModel
import com.nazar.feature.logs.domain.models.toEntity
import com.nazar.feature.logs.entity.toModel
import com.nazar.feature.logs.repository.LogRepository

class LogServiceImpl(private val logRepository: LogRepository):LogService {
    override suspend fun storeLog( logModel: LogModel): Boolean {
        return logRepository.storeLog(logModel.toEntity())
    }

    override suspend fun queryLog(searchString: String): List<LogModel> {
        return logRepository.queryLog(searchString).map { logEntity -> logEntity.toModel() }
    }
}