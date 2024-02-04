package com.nazar.base.providers.database

import com.nazar.feature.logs.entity.LogEntity
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase

interface DatabaseProvider {

    val initializeName: String

    val mongoClient: CoroutineClient

    val database: CoroutineDatabase

    val logCollection: CoroutineCollection<LogEntity>
}