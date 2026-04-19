package com.ctb.data_remote.repository

import com.ctb.commonkotlin.result.Result
import com.ctb.data.datasource.SampleRemoteDataSource
import com.ctb.data_remote.api.SampleApi
import com.ctb.data_remote.response.toDomain
import com.ctb.domain.models.SampleEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SampleRemoteDataSourceImpl(
    private val api: SampleApi
) : SampleRemoteDataSource {
    override fun getSampleData(): Flow<Result<List<SampleEntity>>> = flow {
        try {
            val response = api.getSampleData()
            emit(Result.Success(response.toDomain()))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }

    override suspend fun getSampleById(id: String): Result<SampleEntity> = try {
        val response = api.getSampleById(id)
        Result.Success(response.toDomain())
    } catch (e: Exception) {
        Result.Failure(e)
    }
}
