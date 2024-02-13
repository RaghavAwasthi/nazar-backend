package com.nazar.data.di

import com.mongodb.ConnectionString
import com.nazar.data.database.MongoDBDatabase
import com.nazar.data.database.MongoDBDatabaseImpl
import org.koin.core.qualifier.named

import org.koin.dsl.module


val datamodule= module {

 single<String>(named("DBNAME")){
        "nazar"
 }
    single<MongoDBDatabase>{
        try {
            MongoDBDatabaseImpl(get(named("DBNAME")),get())

        }
        catch (e:Exception){
            println("Error in MongoDBDatabase")
            e.printStackTrace()
            throw e
        }
        }
    // Read Config from properties

//    single<ConnectionString>{
//
//
//    }




}