package com.mirfanrafif.kicksfilm.data.source.remote

import com.mirfanrafif.kicksfilm.data.source.remote.api.TmdbService
import com.mirfanrafif.kicksfilm.data.source.remote.responses.MovieItem
import com.mirfanrafif.kicksfilm.utils.EspressoIdlingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource private constructor(private val tmdbService: TmdbService) {
    companion object {
        private var TAG = RemoteDataSource::class.java.simpleName
        private const val API_KEY = "77aae75f4c0a1788862312068fc792f0"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(tmdbService: TmdbService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(tmdbService).apply {
                    instance = this
                }
            }
    }

    fun discoverMovies(): Flow<ApiResponse<List<MovieItem>>> {
        EspressoIdlingResource.increment()
        return flow {
            try {
                val response = tmdbService.getMovieApiService().discoverMovies(API_KEY)
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
                EspressoIdlingResource.decrement()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)
    }
}