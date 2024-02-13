package com.nazar.feature.logs

import com.nazar.data.database.MongoDBDatabase
import com.nazar.feature.logs.domain.FetchLogsUseCase
import com.nazar.feature.logs.domain.StoreLogUseCase
import com.nazar.feature.logs.entity.LogEntity
import com.nazar.feature.logs.repository.LogRepository
import com.nazar.feature.logs.repository.LogRepositoryImpl
import com.nazar.feature.logs.service.LogService
import com.nazar.feature.logs.service.LogServiceImpl
import org.koin.dsl.module
import org.litote.kmongo.coroutine.CoroutineCollection

val logsfeaturemodule= module {
  single<LogRepository>{
      LogRepositoryImpl(get())
  }
  single <LogService>{
      LogServiceImpl(get())
  }
  single <CoroutineCollection<LogEntity>>{
      get<MongoDBDatabase>().logCollection
  }
  factory<StoreLogUseCase> { StoreLogUseCase(get())  }
    factory<FetchLogsUseCase> { FetchLogsUseCase(get())  }

}
