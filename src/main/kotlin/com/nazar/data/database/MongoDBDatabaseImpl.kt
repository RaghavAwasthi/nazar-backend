package com.nazar.data.database

import com.mongodb.ConnectionString
import com.nazar.feature.logs.entity.LogEntity
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

class MongoDBDatabaseImpl(
    private val databaseName: String,
    private val connectionString: ConnectionString)
    : MongoDBDatabase {

    override val initializeName: String
        get() = databaseName

    override val mongoClient: CoroutineClient
        get() = KMongo.createClient(connectionString).coroutine

    override val database: CoroutineDatabase
        get() = mongoClient.getDatabase(initializeName)

    override val logCollection: CoroutineCollection<LogEntity>
        get() = database.getCollection()

}
