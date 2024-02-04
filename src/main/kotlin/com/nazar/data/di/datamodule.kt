package com.nazar.data.di

import com.nazar.data.database.MongoDBDatabase
import com.nazar.data.database.MongoDBDatabaseImpl
import org.koin.core.qualifier.named

import org.koin.dsl.module


val datamodule= module {

 single<String>(named("DBNAME")){
     "nazar"
 }
    single<MongoDBDatabase>{
        MongoDBDatabaseImpl(get(named("DBNAME")))
    }


}