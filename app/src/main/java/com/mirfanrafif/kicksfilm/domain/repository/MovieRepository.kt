package com.mirfanrafif.kicksfilm.domain.repository

import com.mirfanrafif.kicksfilm.data.NetworkBoundResource
import com.mirfanrafif.kicksfilm.data.Resource
import com.mirfanrafif.kicksfilm.data.source.local.LocalDataSource
import com.mirfanrafif.kicksfilm.data.source.remote.ApiResponse
import com.mirfanrafif.kicksfilm.data.source.remote.RemoteDataSource
import com.mirfanrafif.kicksfilm.data.source.remote.responses.MovieItem
import com.mirfanrafif.kicksfilm.domain.model.Movie
import com.mirfanrafif.kicksfilm.utils.AppExecutor
import com.mirfanrafif.kicksfilm.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

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

    override fun getAllMovies(): Flow<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, List<MovieItem>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovies().map { DataMapper.mapEntityToDomain(it) }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MovieItem>>> {
                return remoteDataSource.discoverMovies()
            }

            override suspend fun saveCallResult(data: List<MovieItem>) {
                val movieList = DataMapper.mapResponsesToEntites(data)
                localDataSource.insertMovie(movieList)
            }

        }.asFlow()
    }

    override fun updateMovie(movie: Movie) {
        val entity = DataMapper.mapDomainToEntity(movie)
        appExecutor.diskIO().execute { localDataSource.updateMovie(entity) }
    }

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovies().map { DataMapper.mapEntityToDomain(it) }
    }


}