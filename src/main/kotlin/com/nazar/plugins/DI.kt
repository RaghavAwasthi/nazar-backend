package com.nazar.plugins

import com.nazar.data.di.datamodule
import com.nazar.feature.logs.logsfeaturemodule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureDI()
{
install(Koin){
    slf4jLogger()
    modules(datamodule+ logsfeaturemodule)
}
}