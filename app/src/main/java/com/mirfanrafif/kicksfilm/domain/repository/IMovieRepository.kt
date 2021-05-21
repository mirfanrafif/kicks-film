package com.mirfanrafif.kicksfilm.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.mirfanrafif.kicksfilm.data.Resource
import com.mirfanrafif.kicksfilm.domain.model.Movie

interface IMovieRepository {
    fun getAllMovies(): LiveData<Resource<PagedList<Movie>>>

    fun updateMovie(movie: Movie)

    fun getFavoriteMovies(): LiveData<PagedList<Movie>>

}