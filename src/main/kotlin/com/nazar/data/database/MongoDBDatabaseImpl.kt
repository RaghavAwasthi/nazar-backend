package com.nazar.data.database

import com.nazar.feature.logs.entity.LogEntity
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

class MongoDBDatabaseImpl(private val clientName: String) : MongoDBDatabase {

    override val initializeName: String
        get() = clientName

    override val mongoClient: CoroutineClient
        get() = KMongo.createClient().coroutine

    override val database: CoroutineDatabase
        get() = mongoClient.getDatabase(initializeName)

    override val logCollection: CoroutineCollection<LogEntity>
        get() = database.getCollection()

}