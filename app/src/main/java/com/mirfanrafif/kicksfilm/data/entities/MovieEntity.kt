package com.mirfanrafif.kicksfilm.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity (
    var id: Int,
    var title: String,
    var year: Int,
    var overview: String,
    var rating: Double,
    var category: String?,
    var photo: String
): Parcelable