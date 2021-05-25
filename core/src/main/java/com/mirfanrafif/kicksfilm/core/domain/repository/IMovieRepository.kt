package com.mirfanrafif.kicksfilm.core.domain.repository

import com.mirfanrafif.kicksfilm.core.data.Resource
import com.mirfanrafif.kicksfilm.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllMovies(): Flow<Resource<List<Movie>>>

    fun updateMovie(movie: Movie)

    fun getFavoriteMovies(): Flow<List<Movie>>

}