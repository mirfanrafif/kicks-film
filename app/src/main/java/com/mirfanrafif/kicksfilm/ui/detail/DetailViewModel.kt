package com.mirfanrafif.kicksfilm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mirfanrafif.kicksfilm.data.MovieRepository
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity

class DetailViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getDetailMovie(id: Int, type: String): LiveData<MovieEntity> =
        when(type) {
            "movie" -> {
                movieRepository.getDetailMovie(id)
            }
            "tvshow" -> {
                movieRepository.getDetailTvShow(id)
            }
            else -> {
                throw Throwable("type not found")
            }
        }
}