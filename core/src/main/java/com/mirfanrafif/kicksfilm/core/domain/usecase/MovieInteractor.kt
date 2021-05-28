package com.mirfanrafif.kicksfilm.core.domain.usecase

import com.mirfanrafif.kicksfilm.core.domain.model.Movie
import com.mirfanrafif.kicksfilm.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val movieRepository: IMovieRepository): MovieUseCase {
    override fun getAllMovies() = movieRepository.getAllMovies()

//    override fun getDetailMovie(id: Int): LiveData<Resource<Movie>> {
//    }

    override fun updateMovie(movie: Movie) = movieRepository.updateMovie(movie)

    override fun getFavoriteMovies(): Flow<List<Movie>> = movieRepository.getFavoriteMovies()
}