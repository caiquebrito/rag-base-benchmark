package com.ctb.data_remote.api

import com.ctb.data_remote.response.SampleResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SampleApi {
    @GET("/api/samples")
    suspend fun getSampleData(): List<SampleResponse>

    @GET("/api/samples/{id}")
    suspend fun getSampleById(@Path("id") id: String): SampleResponse
}
