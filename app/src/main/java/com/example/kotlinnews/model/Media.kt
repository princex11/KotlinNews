package com.example.kotlinnews.model


import android.annotation.SuppressLint
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@JsonClass(generateAdapter = true)
data class Media(
    @Json(name = "oembed")
    val oembed: Oembed? = null,
    @Json(name = "type")
    val type: String? = null
) : Parcelable