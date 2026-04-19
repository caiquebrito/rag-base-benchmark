package com.ctb.commonkotlin.usecase

import com.ctb.commonkotlin.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<in Params, out Result>(
    private val dispatcher: CoroutineDispatcher
) {
    protected abstract fun execute(params: Params): Flow<Result>

    operator fun invoke(params: Params): Flow<Result> =
        execute(params)
            .catch { }
            .flowOn(dispatcher)

    companion object {
        suspend inline operator fun <T> invoke(
            crossinline block: suspend () -> T
        ): com.ctb.commonkotlin.result.Result<T> = try {
            com.ctb.commonkotlin.result.Result.Success(block())
        } catch (e: Exception) {
            com.ctb.commonkotlin.result.Result.Failure(e)
        }
    }
}
