package com.nazar

import com.nazar.base.configureStatusPages
import com.nazar.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {

    configureDI()
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureSecurity()
    configureStatusPages()
    configureRouting()
}
