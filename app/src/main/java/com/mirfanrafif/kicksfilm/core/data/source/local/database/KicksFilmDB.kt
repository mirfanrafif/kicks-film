package com.mirfanrafif.kicksfilm.core.data.source.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mirfanrafif.kicksfilm.core.data.source.local.dao.MovieDao
import com.mirfanrafif.kicksfilm.core.data.source.local.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class KicksFilmDB : RoomDatabase(){

    companion object {
        @Volatile
        private var instance: KicksFilmDB? = null

        @JvmStatic
        fun getDatabase(context: Context): KicksFilmDB {
            if (instance == null) {
                synchronized(KicksFilmDB::class.java) {
                    instance = Room.databaseBuilder(context.applicationContext,
                    KicksFilmDB::class.java, "kicksfilm").build()
                }
            }
            return instance as KicksFilmDB
        }
    }

    abstract fun movieDao(): MovieDao
}