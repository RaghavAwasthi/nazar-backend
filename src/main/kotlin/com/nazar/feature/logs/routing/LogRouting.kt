package com.nazar.feature.logs.routing

import com.nazar.feature.logs.request.LogRequest
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*


fun Application.logroutes(){


    routing {

        post<LogRequest> {
            var req= call.receive<LogRequest>()
        }
    }
}