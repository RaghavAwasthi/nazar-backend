package com.nazar.di

import com.nazar.base.providers.database.DatabaseProvider
import com.nazar.base.providers.database.DatabaseProviderImpl

object DatabaseLocator {

    private fun provideClientName(): String {
        return "nazar"
    }

    fun provideDatabaseProvider(): DatabaseProvider {
        return DatabaseProviderImpl(provideClientName())
    }
}