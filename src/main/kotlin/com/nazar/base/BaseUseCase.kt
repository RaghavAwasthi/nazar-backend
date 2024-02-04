package com.nazar.base

interface BaseUseCase<in I, R : Any> {
    /** Executes this use case with given input. */
    suspend operator fun invoke(input: I): BaseResponse<R>
}