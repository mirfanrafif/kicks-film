package com.mirfanrafif.kicksfilm.di

import com.mirfanrafif.kicksfilm.data.MovieRepository
import com.mirfanrafif.kicksfilm.data.source.remote.RemoteDataSource
import com.mirfanrafif.kicksfilm.data.source.remote.api.TmdbService

object Injection {
    fun provideRepository(): MovieRepository {
        val tmdbService = TmdbService()
        val remoteDataSource = RemoteDataSource.getInstance(tmdbService)
        return MovieRepository.getInstance(remoteDataSource)
    }
}