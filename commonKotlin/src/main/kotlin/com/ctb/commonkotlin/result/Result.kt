package com.ctb.commonkotlin.result

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Failure(val error: Throwable) : Result<Nothing>()

    fun getOrNull(): T? = when (this) {
        is Success -> data
        is Failure -> null
    }

    fun getOrThrow(): T = when (this) {
        is Success -> data
        is Failure -> throw error
    }

    suspend inline fun <R> fold(
        onSuccess: suspend (value: T) -> R,
        onFailure: suspend (throwable: Throwable) -> R
    ): R = when (this) {
        is Success -> onSuccess(data)
        is Failure -> onFailure(error)
    }
}
