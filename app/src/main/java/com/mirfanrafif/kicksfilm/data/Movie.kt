package com.mirfanrafif.kicksfilm.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie (
    var title: String,
    var year: Int,
    var overview: String,
    var rating: Int,
    var director: String,
    var category: String,
    var photo: String
): Parcelable