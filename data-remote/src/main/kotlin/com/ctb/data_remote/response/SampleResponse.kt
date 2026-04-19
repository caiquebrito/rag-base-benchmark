package com.ctb.data_remote.response

import com.ctb.domain.models.SampleEntity
import com.google.gson.annotations.SerializedName

data class SampleResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String
)

fun SampleResponse.toDomain() = SampleEntity(
    id = id,
    name = name,
    description = description
)

fun List<SampleResponse>.toDomain() = map { it.toDomain() }
