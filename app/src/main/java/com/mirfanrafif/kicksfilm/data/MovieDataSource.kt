package com.mirfanrafif.kicksfilm.data

import androidx.lifecycle.LiveData
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity

interface MovieDataSource {
    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getAllTvShows(): LiveData<List<MovieEntity>>

    fun getDetailMovie(id: Int): LiveData<MovieEntity>

    fun getDetailTvShow(id: Int): LiveData<MovieEntity>
}