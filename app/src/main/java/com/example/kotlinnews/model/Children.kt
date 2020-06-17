package com.example.kotlinnews.model


import android.annotation.SuppressLint
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@JsonClass(generateAdapter = true)
data class Children(
    @Json(name = "data")
    val data: DataX? = null,
    @Json(name = "kind")
    val kind: String? = null
) : Parcelable