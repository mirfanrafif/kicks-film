package com.mirfanrafif.kicksfilm.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity

interface MovieDao {
    @Query("SELECT * FROM movieEntities")
    fun getAllMovies(): LiveData<List<MovieEntity>>

    
}