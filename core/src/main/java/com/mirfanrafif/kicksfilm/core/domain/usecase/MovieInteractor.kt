package com.mirfanrafif.kicksfilm.core.domain.usecase

import com.mirfanrafif.kicksfilm.core.data.MovieRepository
import com.mirfanrafif.kicksfilm.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val movieRepository: MovieRepository): MovieUseCase {
    override fun getAllMovies() = movieRepository.getAllMovies()

//    override fun getDetailMovie(id: Int): LiveData<Resource<Movie>> {
//    }

    override fun updateMovie(movie: Movie) = movieRepository.updateMovie(movie)

    override fun getFavoriteMovies(): Flow<List<Movie>> = movieRepository.getFavoriteMovies()
}