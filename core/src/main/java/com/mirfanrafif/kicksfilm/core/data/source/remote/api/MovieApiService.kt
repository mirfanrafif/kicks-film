package com.mirfanrafif.kicksfilm.core.data.source.remote.api

import com.mirfanrafif.kicksfilm.core.data.source.remote.responses.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("3/discover/movie")
    suspend fun discoverMovies(@Query("api_key") apiKey: String): MovieResponse
}