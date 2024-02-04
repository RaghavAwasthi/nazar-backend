package com.nazar.base

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*


fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
        }
        exception<NotFoundException>{ call, cause->
            call.respond(ExceptionResponse(HttpStatusCode.NotFound, cause.message.toString()))
        }
        exception<SomethingWentWrongException>{
            call, cause ->
            call.respond(ExceptionResponse(HttpStatusCode.InternalServerError, cause.message.toString()))

        }
    }
}

class NotFoundException(message: String?) : RuntimeException(message)

class SomethingWentWrongException(message: String = "Something went wrong!") : RuntimeException(message)

data class ExceptionResponse(val code: HttpStatusCode, val message: String? = null)
