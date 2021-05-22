package com.mirfanrafif.kicksfilm.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mirfanrafif.kicksfilm.core.data.Resource
import com.mirfanrafif.kicksfilm.core.domain.model.Movie
import com.mirfanrafif.kicksfilm.core.domain.usecase.MovieUseCase

class MoviesViewModel(private val movieUseCase: MovieUseCase): ViewModel() {
    fun getAllMovies(): LiveData<com.mirfanrafif.kicksfilm.core.data.Resource<List<Movie>>> = movieUseCase.getAllMovies().asLiveData()
}