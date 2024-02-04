package com.nazar.feature.logs.request

import kotlinx.serialization.Serializable

@Serializable
data class QueryLogsRequest(val query:String)
