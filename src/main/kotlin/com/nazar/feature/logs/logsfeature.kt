package com.nazar.feature.logs

import com.nazar.feature.logs.repository.LogRepository
import com.nazar.feature.logs.repository.LogRepositoryImpl
import com.nazar.feature.logs.service.LogService
import com.nazar.feature.logs.service.LogServiceImpl
import org.koin.dsl.module

val logsfeature= module {

  single<LogRepository>{
      LogRepositoryImpl(get())
  }
  single <LogService>{
      LogServiceImpl(get())
  }



}