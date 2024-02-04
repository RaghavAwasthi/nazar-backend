package com.nazar.base

import io.ktor.http.*
import kotlinx.serialization.Serializable

@Serializable
sealed interface BaseResponse<T : Any>

@Serializable
data class SuccessResponse<T : Any>(
    val statusCode: Int,
    val data: T? = null,
) : BaseResponse<T>


@Serializable
data class FailureResponse<T : Any>(
    val statusCode: Int,
    val exception: T? = null,
) : BaseResponse<T>