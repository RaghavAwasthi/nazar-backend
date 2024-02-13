package com.nazar.feature.logs.routing

import com.nazar.feature.logs.domain.FetchLogsUseCase
import com.nazar.feature.logs.domain.StoreLogUseCase
import com.nazar.feature.logs.request.LogRequest
import com.nazar.feature.logs.request.QueryLogsRequest
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Application.logroutes(){

    val storeLogUseCase:StoreLogUseCase by inject()
    val fetchLogsUseCase:FetchLogsUseCase by inject()


    routing {

        post<LogRequest> ("/logs"){
            val resp= storeLogUseCase.invoke(it)
            call.respond(resp)
        }

        get("/logshello") {
            call.respondText("Hello World from log")
        }

        get("/logs"){
            val qstr= call.parameters.get("query")
            println("LOGS are  $qstr")
            val logs= fetchLogsUseCase.invoke(QueryLogsRequest(qstr!!))
            println("LOGS are  $qstr")
            call.respond(logs)


        }
    }
}
