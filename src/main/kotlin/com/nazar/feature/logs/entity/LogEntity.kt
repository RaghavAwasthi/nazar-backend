package com.nazar.feature.logs.entity

import com.nazar.feature.logs.domain.models.LogModel
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class LogEntity(
    @BsonId
    val logId:String= ObjectId().toString(),
    val tag:String,
    val log:String,
)
fun LogEntity.toModel():LogModel{
    return LogModel(this.tag, this.log)
}
