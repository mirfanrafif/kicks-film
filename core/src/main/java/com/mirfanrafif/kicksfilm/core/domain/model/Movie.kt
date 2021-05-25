package com.mirfanrafif.kicksfilm.core.domain.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie (
    var id: Int,
    var title: String,
    var year: Int,
    var overview: String,
    var rating: Double,
    var category: String?,
    var photo: String,
    var isFavorite: Boolean = false
): Parcelable