package com.nazar.feature.logs.request

import kotlinx.serialization.Serializable

@Serializable
data class LogRequest(val tag:String, val log:String)
