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
        private var instance: com.mirfanrafif.kicksfilm.core.data.source.local.database.KicksFilmDB? = null

        @JvmStatic
        fun getDatabase(context: Context): com.mirfanrafif.kicksfilm.core.data.source.local.database.KicksFilmDB {
            if (com.mirfanrafif.kicksfilm.core.data.source.local.database.KicksFilmDB.Companion.instance == null) {
                synchronized(com.mirfanrafif.kicksfilm.core.data.source.local.database.KicksFilmDB::class.java) {
                    com.mirfanrafif.kicksfilm.core.data.source.local.database.KicksFilmDB.Companion.instance = Room.databaseBuilder(context.applicationContext,
                    com.mirfanrafif.kicksfilm.core.data.source.local.database.KicksFilmDB::class.java, "kicksfilm").build()
                }
            }
            return com.mirfanrafif.kicksfilm.core.data.source.local.database.KicksFilmDB.Companion.instance as com.mirfanrafif.kicksfilm.core.data.source.local.database.KicksFilmDB
        }
    }

    abstract fun movieDao(): com.mirfanrafif.kicksfilm.core.data.source.local.dao.MovieDao
}