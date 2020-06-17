package com.example.kotlinnews.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class RequiredInfo(val thumbnailUrl: String?, val articleUrl: String?, val title: String?) :
    Serializable