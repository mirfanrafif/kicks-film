package com.mirfanrafif.kicksfilm.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.mirfanrafif.kicksfilm.data.NetworkBoundResource
import com.mirfanrafif.kicksfilm.data.source.local.LocalDataSource
import com.mirfanrafif.kicksfilm.data.source.remote.ApiResponse
import com.mirfanrafif.kicksfilm.data.source.remote.RemoteDataSource
import com.mirfanrafif.kicksfilm.data.source.remote.responses.*
import com.mirfanrafif.kicksfilm.utils.AppExecutor
import com.mirfanrafif.kicksfilm.data.Resource
import com.mirfanrafif.kicksfilm.domain.model.Movie
import com.mirfanrafif.kicksfilm.utils.DataMapper

class MovieRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutor: AppExecutor
    ) : IMovieRepository {
    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource,
                        localDataSource: LocalDataSource,
                        appExecutor: AppExecutor): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteDataSource, localDataSource, appExecutor)
                    .apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<Movie>>> {
        return object : NetworkBoundResource<PagedList<Movie>, List<MovieItem>>(appExecutor) {
            override fun loadFromDB(): LiveData<PagedList<Movie>> {
                val data = localDataSource.getAllMovies()
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(6)
                    .setPageSize(3)
                    .build()
                val movies = data.map { entity -> DataMapper.mapEntityToDomain(entity) }
                return LivePagedListBuilder(movies, config).build()
            }

            override fun shouldFetch(data: PagedList<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieItem>>> {
                return remoteDataSource.discoverMovies()
            }

            override fun saveCallResult(data: List<MovieItem>) {
                val movieList = DataMapper.mapResponsesToEntites(data)
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

//    override fun getDetailMovie(id: Int): LiveData<Resource<Movie>> {
//        return object : NetworkBoundResource<Movie, MovieDetailResponse>(appExecutor) {
//            override fun loadFromDB(): LiveData<Movie> {
//                val movieEntity = localDataSource.getMoviesById(id)
//                val liveDataMovie = MutableLiveData<Movie>()
//                liveDataMovie.value = DataMapper.mapEntityToDomain(movieEntity)
//                return
//            }
//
//            override fun shouldFetch(data: Movie?): Boolean {
//                return data == null
//            }
//
//            override fun createCall(): LiveData<ApiResponse<MovieDetailResponse>> {
//                return remoteDataSource.getMovie(id)
//            }
//
//            override fun saveCallResult(data: MovieDetailResponse) {
//                val releaseDate = data.releaseDate.split("-").toTypedArray()
//                val categories = data.genres.joinToString { it.name }
//                val movie = MovieEntity(
//                    data.id,
//                    data.title,
//                    releaseDate[0].toInt(),
//                    data.overview,
//                    data.voteAverage,
//                    categories,
//                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2${data.backdropPath}")
//                localDataSource.updateMovie(movie)
//            }
//
//        }.asLiveData()
//    }

    override fun updateMovie(movie: Movie) {
        val entity = DataMapper.mapDomainToEntity(movie)
        appExecutor.diskIO().execute { localDataSource.updateMovie(entity) }
    }


    override fun getFavoriteMovies(): LiveData<PagedList<Movie>> {
        val data = localDataSource.getFavoriteMovies()
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .build()
        val movies= data.map { entity -> DataMapper.mapEntityToDomain(entity) }
        return LivePagedListBuilder(movies, config).build()
    }


}