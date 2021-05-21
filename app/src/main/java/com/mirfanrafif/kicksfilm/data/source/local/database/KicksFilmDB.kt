package com.mirfanrafif.kicksfilm.data.source.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity
import com.mirfanrafif.kicksfilm.data.source.local.dao.MovieDao

@Database(entities = [MovieEntity::class], version = 1)
abstract class KicksFilmDB : RoomDatabase(){
    abstract fun movieDao(): MovieDao

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
}