package com.ctb.data.repository

import com.ctb.commonkotlin.result.Result
import com.ctb.data.datasource.SampleRemoteDataSource
import com.ctb.domain.models.SampleEntity
import com.ctb.domain.repositories.SampleRepository
import kotlinx.coroutines.flow.Flow

class SampleRepositoryImpl(
    private val remoteDataSource: SampleRemoteDataSource
) : SampleRepository {
    override fun getSampleData(): Flow<Result<List<SampleEntity>>> =
        remoteDataSource.getSampleData()

    override suspend fun getSampleById(id: String): Result<SampleEntity> =
        remoteDataSource.getSampleById(id)
}
