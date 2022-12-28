package com.hdt.onlinegroceries.di

import com.google.gson.Gson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

val networkModule =  module {
    single(createdAtStart = true) { createOkHttpClient() }
    factory { createConverterFactory() }
    single { Gson() }
}

private fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addNetworkInterceptor(createHeaderInterceptor())
        .build()
}

private fun createHeaderInterceptor(): Interceptor {
    return Interceptor { chain ->
        val timezone = TimeZone
            .getDefault()
            .getDisplayName(false, TimeZone.SHORT, Locale.ENGLISH)
            .substring(3)
        val newRequest = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .addHeader("Accept", "text/plain")
            .addHeader("Accept", "*/*")
            .addHeader("Timezone", timezone)
            .build()
        chain.proceed(newRequest)
    }
}

val moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private fun createConverterFactory(): MoshiConverterFactory {
    return MoshiConverterFactory.create(moshi)
}

private inline fun <reified T> createService(
    okHttpClient: OkHttpClient,
    converterFactory: MoshiConverterFactory,
    baseUrl: String = ""
): T {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .build()
        .create(T::class.java)
}