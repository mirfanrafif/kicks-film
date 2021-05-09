package com.mirfanrafif.kicksfilm.data.source.remote

import android.util.Log
import com.mirfanrafif.kicksfilm.data.source.remote.responses.MovieDetailResponse
import com.mirfanrafif.kicksfilm.data.source.remote.responses.MovieResponse
import com.mirfanrafif.kicksfilm.data.source.remote.responses.TvDetailResponse
import com.mirfanrafif.kicksfilm.data.source.remote.responses.TvResponse
import com.mirfanrafif.kicksfilm.utils.EspressoIdlingResource
import com.mirfanrafif.kicksfilm.data.source.remote.api.TmdbService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val tmdbService: TmdbService){
    companion object {
        private var TAG = RemoteDataSource::class.java.simpleName
        private const val API_KEY = "77aae75f4c0a1788862312068fc792f0"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(tmdbService: TmdbService): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(tmdbService).apply {
                instance = this
            }
        }
    }

    fun discoverMovies(callback: LoadMoviesCallback){
        EspressoIdlingResource.increment()
        tmdbService.getMovieApiService().discoverMovies(API_KEY).enqueue(object :
            Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        callback.onLoadMovies(data)
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "Error: ${t.message}")
            }

        })

    }

    fun discoverTvShow(callback: LoadTvShowCallback) {
        EspressoIdlingResource.increment()
        tmdbService.getTvShowApiService().discoverTvShows(API_KEY).enqueue(object :
            Callback<TvResponse> {
            override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                if (response.isSuccessful) {
                    val tvShowList = response.body()
                    if (tvShowList != null) {
                        callback.onLoadTvShows(tvShowList)
                        EspressoIdlingResource.decrement()
                    }
                }
            }

            override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                Log.e(TAG, "Error: ${t.message}")
            }

        })
    }

    fun getMovie(id: Int, callback: LoadMovieDetailsCallback){
        EspressoIdlingResource.increment()
        tmdbService.getMovieApiService().getMovie(id, API_KEY).enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        EspressoIdlingResource.decrement()
                        callback.onLoadMovieDetails(data)
                    }
                }
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.e(TAG, "Error: ${t.message}")
            }

        })
    }

    fun getTvShow(id: Int, callback: LoadTvShowDetailsCallback){
        EspressoIdlingResource.increment()
        tmdbService.getTvShowApiService().getTvShow(id, API_KEY).enqueue(object : Callback<TvDetailResponse> {
            override fun onResponse(
                call: Call<TvDetailResponse>,
                response: Response<TvDetailResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        EspressoIdlingResource.decrement()
                        callback.onLoadTvShowDetails(data)
                    }
                }
            }

            override fun onFailure(call: Call<TvDetailResponse>, t: Throwable) {
                Log.e(TAG, "Error: ${t.message}")
            }

        })
    }

    interface LoadMoviesCallback {
        fun onLoadMovies(movieResponse: MovieResponse)
    }

    interface LoadTvShowCallback {
        fun onLoadTvShows(tvResponse: TvResponse)
    }

    interface LoadMovieDetailsCallback {
        fun onLoadMovieDetails(movieDetailResponse: MovieDetailResponse)
    }

    interface LoadTvShowDetailsCallback {
        fun onLoadTvShowDetails(tvShowDetailResponse: TvDetailResponse)
    }
}