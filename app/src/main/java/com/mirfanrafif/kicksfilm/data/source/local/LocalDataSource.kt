package com.mirfanrafif.kicksfilm.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity
import com.mirfanrafif.kicksfilm.data.source.local.dao.MovieDao

class LocalDataSource private constructor(
    private val movieDao: MovieDao){

    companion object {
        @Volatile
        private var instance: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource {
            return instance ?: LocalDataSource(movieDao)
        }
    }

    fun getAllMovies() : DataSource.Factory<Int, MovieEntity> = movieDao.getAllMovies()

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> = movieDao.getFavoriteMovie()

    fun getMoviesById(id: Int): LiveData<MovieEntity> = movieDao.getMovieById(id)

    fun insertMovie(movieEntity: List<MovieEntity>) = movieDao.insert(movieEntity)

    fun updateMovie(movieEntity: MovieEntity) = movieDao.update(movieEntity)


}