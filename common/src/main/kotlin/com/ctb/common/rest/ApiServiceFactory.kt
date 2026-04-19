package com.ctb.common.rest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceFactory {
    fun <T> create(
        baseUrl: String,
        serviceClass: Class<T>,
        client: OkHttpClient
    ): T = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(serviceClass)
}
