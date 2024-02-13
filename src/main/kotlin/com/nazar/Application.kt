package com.nazar

import com.nazar.base.configureStatusPages
import com.nazar.plugins.*
import com.nazar.util.ENVNAME
import com.nazar.util.getEnvironmentVariable
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}



fun Application.module() {
    configureDI(environment.config)
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureSecurity()
    configureStatusPages()
    configureRouting()
}
