package com.example.kotlinnews.model


import android.annotation.SuppressLint
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import kotlinx.android.parcel.RawValue

@SuppressLint("ParcelCreator")
@Parcelize
@JsonClass(generateAdapter = true)
data class Data @JvmOverloads constructor(
    @Json(name = "after")
    val after: String? = null,
    @Json(name = "before")
    val before: @RawValue Any? = null,
    @Json(name = "children")
    val children: List<Children>? = null,
    @Json(name = "dist")
    val dist: Int? = null,
    @Json(name = "modhash")
    val modhash: String? = null
) : Parcelable