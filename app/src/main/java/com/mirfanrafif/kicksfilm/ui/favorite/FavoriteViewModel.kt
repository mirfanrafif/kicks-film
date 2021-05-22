package com.mirfanrafif.kicksfilm.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mirfanrafif.kicksfilm.core.domain.usecase.MovieUseCase

class FavoriteViewModel(private val movieUseCase: MovieUseCase): ViewModel() {

    fun getFavoriteMovies() = movieUseCase.getFavoriteMovies().asLiveData()
}