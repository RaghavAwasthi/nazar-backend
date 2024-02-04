package com.nazar.base.providers.service

import com.nazar.feature.logs.repository.LogRepository

interface ServiceProvider {

    fun provideLogService(): LogRepository
}