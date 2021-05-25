package com.mirfanrafif.kicksfilm.core.data

import com.mirfanrafif.kicksfilm.core.data.source.remote.ApiResponse
import com.mirfanrafif.kicksfilm.core.data.source.remote.RemoteDataSource
import com.mirfanrafif.kicksfilm.core.data.source.remote.responses.MovieItem
import com.mirfanrafif.kicksfilm.core.domain.model.Movie
import com.mirfanrafif.kicksfilm.core.domain.repository.IMovieRepository
import com.mirfanrafif.kicksfilm.core.utils.AppExecutor
import com.mirfanrafif.kicksfilm.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: com.mirfanrafif.kicksfilm.core.data.source.local.LocalDataSource,
    private val appExecutor: AppExecutor
    ) : IMovieRepository {

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