package com.mirfanrafif.kicksfilm.core.domain.usecase

import com.mirfanrafif.kicksfilm.core.data.Resource
import com.mirfanrafif.kicksfilm.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovies(): Flow<Resource<List<Movie>>>

//    fun getDetailMovie(id: Int): LiveData<Resource<Movie>>

    fun updateMovie(movie: Movie)

    fun getFavoriteMovies(): Flow<List<Movie>>
}