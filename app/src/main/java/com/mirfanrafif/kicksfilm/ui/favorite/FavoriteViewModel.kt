package com.mirfanrafif.kicksfilm.ui.favorite

import androidx.lifecycle.ViewModel
import com.mirfanrafif.kicksfilm.data.MovieRepository
import com.mirfanrafif.kicksfilm.data.source.local.LocalDataSource

class FavoriteViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getFavoriteMovies() = movieRepository.getFavoriteMovies()
    fun getFavoriteTvShows() = movieRepository.getFavoriteTvShows()
}