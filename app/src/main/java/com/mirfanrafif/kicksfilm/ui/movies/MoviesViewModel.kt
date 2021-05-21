package com.mirfanrafif.kicksfilm.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.mirfanrafif.kicksfilm.data.Resource
import com.mirfanrafif.kicksfilm.domain.model.Movie
import com.mirfanrafif.kicksfilm.domain.usecase.MovieUseCase

class MoviesViewModel(private val movieUseCase: MovieUseCase): ViewModel() {

    fun getAllMovies(): LiveData<Resource<PagedList<Movie>>> = movieUseCase.getAllMovies()
}