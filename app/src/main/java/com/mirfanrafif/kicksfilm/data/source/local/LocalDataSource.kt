package com.mirfanrafif.kicksfilm.data.source.local

import com.mirfanrafif.kicksfilm.data.source.local.dao.MovieDao
import com.mirfanrafif.kicksfilm.data.source.local.entities.MovieEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(
    private val movieDao: MovieDao){

    companion object {
        @Volatile
        private var instance: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource {
            return instance ?: LocalDataSource(movieDao)
        }
    }

    fun getAllMovies() : Flow<List<MovieEntity>> = movieDao.getAllMovies()

    fun getFavoriteMovies(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

//    fun getMoviesById(id: Int): Flow<MovieEntity> = movieDao.getMovieById(id)

    suspend fun insertMovie(movieEntity: List<MovieEntity>) = movieDao.insert(movieEntity)

    fun updateMovie(movieEntity: MovieEntity) = movieDao.update(movieEntity)


}