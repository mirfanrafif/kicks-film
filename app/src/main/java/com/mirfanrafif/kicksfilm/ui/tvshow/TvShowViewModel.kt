package com.mirfanrafif.kicksfilm.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mirfanrafif.kicksfilm.data.MovieRepository
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getAllTvShow(): LiveData<List<MovieEntity>> = movieRepository.getAllTvShows()
}