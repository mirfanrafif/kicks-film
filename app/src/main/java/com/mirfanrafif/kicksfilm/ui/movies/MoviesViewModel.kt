package com.mirfanrafif.kicksfilm.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mirfanrafif.kicksfilm.data.Resource
import com.mirfanrafif.kicksfilm.domain.model.Movie
import com.mirfanrafif.kicksfilm.domain.usecase.MovieUseCase

class MoviesViewModel(private val movieUseCase: MovieUseCase): ViewModel() {
    fun getAllMovies(): LiveData<Resource<List<Movie>>> = movieUseCase.getAllMovies().asLiveData()
}