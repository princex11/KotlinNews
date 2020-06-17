package com.example.kotlinnews.model


import android.annotation.SuppressLint
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@JsonClass(generateAdapter = true)
data class C789efqbqh451(
    @Json(name = "e")
    val e: String? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "m")
    val m: String? = null,
    @Json(name = "p")
    val p: List<P>? = null,
    @Json(name = "s")
    val s: S? = null,
    @Json(name = "status")
    val status: String? = null
) : Parcelable