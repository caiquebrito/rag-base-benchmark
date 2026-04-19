package com.ctb.domain.repositories

import com.ctb.domain.models.SampleEntity
import com.ctb.commonkotlin.result.Result
import kotlinx.coroutines.flow.Flow

interface SampleRepository {
    fun getSampleData(): Flow<Result<List<SampleEntity>>>
    suspend fun getSampleById(id: String): Result<SampleEntity>
}
