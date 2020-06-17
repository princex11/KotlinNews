package com.example.kotlinnews.model


import android.annotation.SuppressLint
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@JsonClass(generateAdapter = true)
data class Oembed(
    @Json(name = "author_name")
    val authorName: String? = null,
    @Json(name = "author_url")
    val authorUrl: String? = null,
    @Json(name = "height")
    val height: Int? = null,
    @Json(name = "html")
    val html: String? = null,
    @Json(name = "provider_name")
    val providerName: String? = null,
    @Json(name = "provider_url")
    val providerUrl: String? = null,
    @Json(name = "thumbnail_height")
    val thumbnailHeight: Int? = null,
    @Json(name = "thumbnail_url")
    val thumbnailUrl: String? = null,
    @Json(name = "thumbnail_width")
    val thumbnailWidth: Int? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "version")
    val version: String? = null,
    @Json(name = "width")
    val width: Int? = null
) : Parcelable