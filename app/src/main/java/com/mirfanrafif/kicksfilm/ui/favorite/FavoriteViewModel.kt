package com.mirfanrafif.kicksfilm.ui.favorite

import androidx.lifecycle.ViewModel
import com.mirfanrafif.kicksfilm.domain.repository.MovieRepository
import com.mirfanrafif.kicksfilm.domain.usecase.MovieUseCase

class FavoriteViewModel(private val movieUseCase: MovieUseCase): ViewModel() {

    fun getFavoriteMovies() = movieUseCase.getFavoriteMovies()
}