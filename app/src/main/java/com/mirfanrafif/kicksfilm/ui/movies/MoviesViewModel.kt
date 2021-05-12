package com.mirfanrafif.kicksfilm.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mirfanrafif.kicksfilm.data.MovieRepository
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity
import com.mirfanrafif.kicksfilm.vo.Resource

class MoviesViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>> = movieRepository.getAllMovies()
}