package com.mirfanrafif.kicksfilm.data.source.local.dao

import androidx.room.*
import com.mirfanrafif.kicksfilm.data.source.local.entities.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movieEntities ORDER BY movieId ASC")
    fun getAllMovies() : Flow<List<MovieEntity>>

    @Query("SELECT * FROM movieEntities WHERE movieId = :movieId LIMIT 1")
    fun getMovieById(movieId: Int): Flow<MovieEntity>

    @Query("SELECT * FROM movieEntities WHERE isFavorite = 1")
    fun getFavoriteMovie(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(data: List<MovieEntity>): List<Long>

    @Update
    fun update(movieEntity: MovieEntity)
}