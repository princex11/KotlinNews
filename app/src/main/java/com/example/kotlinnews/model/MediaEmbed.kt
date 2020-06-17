package com.example.kotlinnews.model


import android.annotation.SuppressLint
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@JsonClass(generateAdapter = true)
data class MediaEmbed(
    @Json(name = "content")
    val content: String? = null,
    @Json(name = "height")
    val height: Int? = null,
    @Json(name = "scrolling")
    val scrolling: Boolean? = null,
    @Json(name = "width")
    val width: Int? = null
) : Parcelable