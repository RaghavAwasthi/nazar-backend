package com.nazar.base.providers.service

import com.nazar.di.DatabaseLocator
import com.nazar.feature.logs.repository.LogRepository
import com.nazar.feature.logs.repository.LogRepositoryImpl

class ServiceProviderImpl(private val databaseLocator:DatabaseLocator ):ServiceProvider {
    override fun provideLogService(): LogRepository {
        return LogRepositoryImpl(databaseLocator.provideDatabaseProvider().logCollection)
    }


}