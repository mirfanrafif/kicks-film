package com.mirfanrafif.kicksfilm.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mirfanrafif.kicksfilm.core.domain.usecase.MovieUseCase

class MoviesViewModel(private val movieUseCase: MovieUseCase): ViewModel() {
    fun getAllMovies() = movieUseCase.getAllMovies().asLiveData()
}