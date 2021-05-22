package com.mirfanrafif.kicksfilm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mirfanrafif.kicksfilm.core.domain.model.Movie
import com.mirfanrafif.kicksfilm.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase): ViewModel() {

    private val movie = MutableLiveData<Movie>()

    fun getMovie() : LiveData<Movie> = movie

    fun setMovie(input: Movie) {
        movie.value = input
    }

    fun updateMovie(movie: Movie) = movieUseCase.updateMovie(movie)
}