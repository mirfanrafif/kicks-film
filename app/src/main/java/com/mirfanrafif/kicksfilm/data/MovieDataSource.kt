package com.mirfanrafif.kicksfilm.data

import androidx.lifecycle.LiveData
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity
import com.mirfanrafif.kicksfilm.data.entities.TvShowEntity
import com.mirfanrafif.kicksfilm.vo.Resource

interface MovieDataSource {
    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>>

    fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>>

    fun getDetailMovie(id: Int): LiveData<Resource<MovieEntity>>

    fun getDetailTvShow(id: Int): LiveData<Resource<TvShowEntity>>

    fun updateMovie(movieEntity: MovieEntity)

    fun updateTvShow(tvShowEntity: TvShowEntity)

    fun getFavoriteMovies(): LiveData<List<MovieEntity>>

    fun getFavoriteTvShows(): LiveData<List<TvShowEntity>>
}