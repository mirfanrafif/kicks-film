package com.mirfanrafif.kicksfilm.core.data.source.local

import com.mirfanrafif.kicksfilm.core.data.source.local.dao.MovieDao
import com.mirfanrafif.kicksfilm.core.data.source.local.entities.MovieEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource constructor(
    private val movieDao: MovieDao
){

    fun getAllMovies() : Flow<List<MovieEntity>> = movieDao.getAllMovies()

    fun getFavoriteMovies(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

//    fun getMoviesById(id: Int): Flow<MovieEntity> = movieDao.getMovieById(id)

    suspend fun insertMovie(movieEntity: List<MovieEntity>) = movieDao.insert(movieEntity)

    fun updateMovie(movieEntity: MovieEntity) = movieDao.update(movieEntity)


}