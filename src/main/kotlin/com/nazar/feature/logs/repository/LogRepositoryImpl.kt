package com.nazar.feature.logs.repository

import com.nazar.feature.logs.entity.LogEntity
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.regex

class LogRepositoryImpl(private val logCollection:CoroutineCollection<LogEntity>): LogRepository {
    override suspend fun storeLog(logEntity: LogEntity): Boolean {
        return logCollection.insertOne(logEntity).wasAcknowledged()
    }

    override suspend fun queryLog(searchString:String): List<LogEntity> {
        return logCollection.find(LogEntity::log regex searchString).toList()
    }
}