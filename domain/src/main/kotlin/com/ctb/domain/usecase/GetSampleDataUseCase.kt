package com.ctb.domain.usecase

import com.ctb.commonkotlin.result.Result
import com.ctb.commonkotlin.usecase.FlowUseCase
import com.ctb.domain.models.SampleEntity
import com.ctb.domain.repositories.SampleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetSampleDataUseCase(
    private val repository: SampleRepository,
    dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, Result<List<SampleEntity>>>(dispatcher) {
    override fun execute(params: Unit): Flow<Result<List<SampleEntity>>> =
        repository.getSampleData()
}
