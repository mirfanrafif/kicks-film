package com.mirfanrafif.kicksfilm.ui.detail

import androidx.lifecycle.ViewModel
import com.mirfanrafif.kicksfilm.data.Movie

class DetailViewModel: ViewModel() {
    private lateinit var movie: Movie

    fun setData(data: Movie) {
        movie = data
    }

    fun getData(): Movie = movie
}