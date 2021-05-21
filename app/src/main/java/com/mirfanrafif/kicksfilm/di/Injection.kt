package com.mirfanrafif.kicksfilm.di

import android.content.Context
import com.mirfanrafif.kicksfilm.domain.repository.MovieRepository
import com.mirfanrafif.kicksfilm.data.source.local.LocalDataSource
import com.mirfanrafif.kicksfilm.data.source.local.database.KicksFilmDB
import com.mirfanrafif.kicksfilm.data.source.remote.RemoteDataSource
import com.mirfanrafif.kicksfilm.data.source.remote.api.TmdbService
import com.mirfanrafif.kicksfilm.domain.usecase.MovieInteractor
import com.mirfanrafif.kicksfilm.domain.usecase.MovieUseCase
import com.mirfanrafif.kicksfilm.utils.AppExecutor

object Injection {
    fun provideRepository(context: Context): MovieRepository {
        val database = KicksFilmDB.getDatabase(context)

        val localDataSource = LocalDataSource.getInstance(database.movieDao())

        val appExecutor = AppExecutor()
        val tmdbService = TmdbService()
        val remoteDataSource = RemoteDataSource.getInstance(tmdbService)
        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutor)
    }

    fun provideUseCase(context: Context): MovieUseCase {
        val repository = provideRepository(context)
        return MovieInteractor(repository)
    }
}