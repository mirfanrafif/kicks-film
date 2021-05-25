package com.mirfanrafif.kicksfilm.core.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mirfanrafif.kicksfilm.core.data.source.local.dao.MovieDao
import com.mirfanrafif.kicksfilm.core.data.source.local.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class KicksFilmDB : RoomDatabase(){

    abstract fun movieDao(): MovieDao
}