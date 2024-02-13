package com.nazar.plugins

import com.nazar.feature.logs.routing.logroutes
import io.ktor.http.*
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.resources.*
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {

    install(Resources)
    logroutes()
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

    }
}
