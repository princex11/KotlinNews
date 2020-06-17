package com.example.kotlinnews.network

import com.example.kotlinnews.BuildConfig
import com.example.kotlinnews.model.Model
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.reddit.com"

private val client = OkHttpClient().newBuilder()
    .addInterceptor(HttpLoggingInterceptor().apply {
        level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    })
    .build()

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .client(client)
    .baseUrl(BASE_URL)
    .build()

interface KotlinNewsApiService {
    @GET("r/kotlin/.json")
    fun getKotlinNews(): Deferred<Model>
}

object KotlinNewsApi {
    val retrofitService: KotlinNewsApiService by lazy {
        retrofit.create(KotlinNewsApiService::class.java)
    }
}