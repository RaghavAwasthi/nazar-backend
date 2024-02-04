package com.nazar.feature.logs.domain.models

import com.nazar.feature.logs.entity.LogEntity

data class LogModel(val tag:String,val logMessage:String)
fun LogModel.toEntity():LogEntity{ return LogEntity(tag = this.tag, log = this.logMessage) }


