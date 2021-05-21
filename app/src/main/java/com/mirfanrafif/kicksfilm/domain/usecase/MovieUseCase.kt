package com.mirfanrafif.kicksfilm.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.mirfanrafif.kicksfilm.data.Resource
import com.mirfanrafif.kicksfilm.domain.model.Movie

interface MovieUseCase {
    fun getAllMovies(): LiveData<Resource<PagedList<Movie>>>

//    fun getDetailMovie(id: Int): LiveData<Resource<Movie>>

    fun updateMovie(movie: Movie)

    fun getFavoriteMovies(): LiveData<PagedList<Movie>>
}