package com.nazar.plugins

import com.mongodb.ConnectionString
import com.nazar.CONFIG_NAME
import com.nazar.data.di.datamodule
import com.nazar.feature.logs.logsfeaturemodule
import com.nazar.util.ENVNAME
import com.nazar.util.getEnvironmentVariable
import io.ktor.server.application.*
import io.ktor.server.config.*
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureDI(configs:ApplicationConfig)
{
    val configModule= module{
        single<ApplicationConfig>{
            configs
        }

        single<ConnectionString>{
            ConnectionString(getEnvironmentVariable(ENVNAME.CONNECTION_STRING))
        }
    }


install(Koin){
    slf4jLogger()
    modules(datamodule+ logsfeaturemodule+ configModule)
}
}

