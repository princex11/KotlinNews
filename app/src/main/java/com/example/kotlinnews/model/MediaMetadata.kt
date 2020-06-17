package com.example.kotlinnews.model


import android.annotation.SuppressLint
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@JsonClass(generateAdapter = true)
data class MediaMetadata(
    @Json(name = "c789efqbqh451")
    val c789efqbqh451: C789efqbqh451? = null
) : Parcelable