package com.mirfanrafif.kicksfilm.domain.repository

import com.mirfanrafif.kicksfilm.data.Resource
import com.mirfanrafif.kicksfilm.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllMovies(): Flow<Resource<List<Movie>>>

    fun updateMovie(movie: Movie)

    fun getFavoriteMovies(): Flow<List<Movie>>

}