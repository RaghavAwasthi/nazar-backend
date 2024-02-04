package com.nazar.base

import io.ktor.http.*

interface BaseResponse<T : Any>

data class SuccessResponse<T : Any>(
    val statusCode: HttpStatusCode,
    val data: T? = null,
) : BaseResponse<T>

data class FailureResponse<T : Any>(
    val statusCode: HttpStatusCode,
    val exception: T? = null,
) : BaseResponse<T>