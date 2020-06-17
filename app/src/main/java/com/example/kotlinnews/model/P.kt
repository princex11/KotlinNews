package com.example.kotlinnews.model


import android.annotation.SuppressLint
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@JsonClass(generateAdapter = true)
data class P(
    @Json(name = "u")
    val u: String? = null,
    @Json(name = "x")
    val x: Int? = null,
    @Json(name = "y")
    val y: Int? = null
) : Parcelable