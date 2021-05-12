package com.mirfanrafif.kicksfilm.data.source.local

import androidx.lifecycle.LiveData
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity
import com.mirfanrafif.kicksfilm.data.entities.TvShowEntity
import com.mirfanrafif.kicksfilm.data.source.local.dao.MovieDao
import com.mirfanrafif.kicksfilm.data.source.local.dao.TvShowDao

class LocalDataSource private constructor(
    private val movieDao: MovieDao, private val tvShowDao: TvShowDao){

    companion object {
        @Volatile
        private var instance: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao, tvShowDao: TvShowDao): LocalDataSource {
            return instance ?: LocalDataSource(movieDao, tvShowDao)
        }
    }

    fun getAllMovies(): LiveData<List<MovieEntity>> = movieDao.getAllMovies()

    fun getFavoriteMovies(): LiveData<List<MovieEntity>> = movieDao.getFavoriteMovie()

    fun getMoviesById(id: Int): LiveData<MovieEntity> = movieDao.getMovieById(id)

    fun insertMovie(movieEntity: List<MovieEntity>) = movieDao.insert(movieEntity)

    fun updateMovie(movieEntity: MovieEntity) = movieDao.update(movieEntity)

    fun deleteMovie(movieEntity: MovieEntity) = movieDao.delete(movieEntity)

    fun geAlltTvShow() : LiveData<List<TvShowEntity>> = tvShowDao.getAllMovies()

    fun getFavoriteTvShow(): LiveData<List<TvShowEntity>> = tvShowDao.getFavoriteMovie()

    fun getTvShowById(id: Int): LiveData<TvShowEntity> = tvShowDao.getMovieById(id)

    fun insertTvShow(entity: List<TvShowEntity>) = tvShowDao.insert(entity)

    fun updateTvShow(entity: TvShowEntity) = tvShowDao.update(entity)

    fun deleteTvShow(entity: TvShowEntity) = tvShowDao.delete(entity)

}