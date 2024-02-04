package com.nazar.di

import com.nazar.base.providers.service.ServiceProvider
import com.nazar.base.providers.service.ServiceProviderImpl
import com.nazar.feature.logs.repository.LogRepository

object ServiceLocator {
    fun provideLogService(): LogRepository {
        return provideServiceProvider().provideLogService()
    }

    private fun provideServiceProvider():ServiceProvider{
        return ServiceProviderImpl(DatabaseLocator)
    }
}