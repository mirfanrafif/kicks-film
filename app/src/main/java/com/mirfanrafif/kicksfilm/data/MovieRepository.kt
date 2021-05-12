package com.mirfanrafif.kicksfilm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity
import com.mirfanrafif.kicksfilm.data.entities.TvShowEntity
import com.mirfanrafif.kicksfilm.data.source.remote.RemoteDataSource
import com.mirfanrafif.kicksfilm.data.source.remote.RemoteDataSource.*
import com.mirfanrafif.kicksfilm.data.source.remote.responses.MovieDetailResponse
import com.mirfanrafif.kicksfilm.data.source.remote.responses.MovieResponse
import com.mirfanrafif.kicksfilm.data.source.remote.responses.TvDetailResponse
import com.mirfanrafif.kicksfilm.data.source.remote.responses.TvResponse

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieDataSource{
    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteDataSource).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movies = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.discoverMovies(object : LoadMoviesCallback {
            override fun onLoadMovies(movieResponse: MovieResponse) {
                val movieList = ArrayList<MovieEntity>()
                for (result in movieResponse.results) {
                    val releaseDate = result.releaseDate.split("-").toTypedArray()
                    val movie = MovieEntity(
                        result.id,
                        result.title,
                        releaseDate[0].toInt(),
                        result.overview,
                        result.voteAverage,
                        null,
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2${result.backdropPath}")
                    movieList.add(movie)
                }
                movies.postValue(movieList)
            }

        })
        return movies
    }

    override fun getAllTvShows(): LiveData<List<TvShowEntity>> {
        val tvShow = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.discoverTvShow(object : LoadTvShowCallback {
            override fun onLoadTvShows(tvResponse: TvResponse) {
                val tvShowList = tvResponse.results.map {
                    val releaseDate = it.firstAirDate.split("-").toTypedArray()
                    TvShowEntity(
                        it.id,
                        it.name,
                        releaseDate[0].toInt(),
                        it.overview,
                        it.voteAverage,
                        null,
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2${it.backdropPath}")
                }
                tvShow.postValue(tvShowList)
            }

        })
        return tvShow
    }

    override fun getDetailMovie(id: Int): LiveData<MovieEntity> {
        val movieLiveData = MutableLiveData<MovieEntity>()
        remoteDataSource.getMovie(id, object : LoadMovieDetailsCallback {
            override fun onLoadMovieDetails(movieDetailResponse: MovieDetailResponse) {
                val releaseDate = movieDetailResponse.releaseDate.split("-").toTypedArray()
                val categories = movieDetailResponse.genres.joinToString() { it.name }
                val movie = MovieEntity(
                    movieDetailResponse.id,
                    movieDetailResponse.title,
                    releaseDate[0].toInt(),
                    movieDetailResponse.overview,
                    movieDetailResponse.voteAverage,
                    categories,
                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2${movieDetailResponse.backdropPath}")
                movieLiveData.postValue(movie)
            }

        })
        return movieLiveData
    }

    override fun getDetailTvShow(id: Int): LiveData<TvShowEntity> {
        val tv = MutableLiveData<TvShowEntity>()

        remoteDataSource.getTvShow(id, object : LoadTvShowDetailsCallback {
            override fun onLoadTvShowDetails(tvShowDetailResponse: TvDetailResponse) {
                val releaseDate = tvShowDetailResponse.firstAirDate.split("-").toTypedArray()
                val categories = tvShowDetailResponse.genres.joinToString() { it.name }
                val tvShowEntity = TvShowEntity(
                    tvShowDetailResponse.id,
                    tvShowDetailResponse.name,
                    releaseDate[0].toInt(),
                    tvShowDetailResponse.overview,
                    tvShowDetailResponse.voteAverage,
                    categories,
                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2${tvShowDetailResponse.backdropPath}")
                tv.postValue(tvShowEntity)
            }

        })
        return tv
    }

}