package com.mirfanrafif.kicksfilm.core.data.source.remote

import com.mirfanrafif.kicksfilm.core.data.source.remote.api.MovieApiService
import com.mirfanrafif.kicksfilm.core.data.source.remote.responses.MovieItem
import com.mirfanrafif.kicksfilm.core.utils.EspressoIdlingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource constructor(private val service: MovieApiService) {
    companion object {
        private const val API_KEY = "77aae75f4c0a1788862312068fc792f0"
    }

    fun discoverMovies(): Flow<ApiResponse<List<MovieItem>>> {
        EspressoIdlingResource.increment()
        return flow {
            try {
                val response = service.discoverMovies(API_KEY)
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