package com.mirfanrafif.kicksfilm.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mirfanrafif.kicksfilm.data.MovieRepository
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity

class MoviesViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getAllMovies(): LiveData<List<MovieEntity>> = movieRepository.getAllMovies()
}