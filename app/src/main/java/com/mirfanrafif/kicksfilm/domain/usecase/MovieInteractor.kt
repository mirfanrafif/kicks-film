package com.mirfanrafif.kicksfilm.domain.usecase

import com.mirfanrafif.kicksfilm.data.Resource
import com.mirfanrafif.kicksfilm.domain.model.Movie
import com.mirfanrafif.kicksfilm.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val movieRepository: MovieRepository): MovieUseCase {
    override fun getAllMovies(): Flow<Resource<List<Movie>>> = movieRepository.getAllMovies()

//    override fun getDetailMovie(id: Int): LiveData<Resource<Movie>> {
//    }

    override fun updateMovie(movie: Movie) = movieRepository.updateMovie(movie)

    override fun getFavoriteMovies(): Flow<List<Movie>> = movieRepository.getFavoriteMovies()
}