package com.mirfanrafif.kicksfilm.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.mirfanrafif.kicksfilm.data.Resource
import com.mirfanrafif.kicksfilm.domain.model.Movie
import com.mirfanrafif.kicksfilm.domain.repository.MovieRepository

class MovieInteractor(private val movieRepository: MovieRepository): MovieUseCase {
    override fun getAllMovies(): LiveData<Resource<PagedList<Movie>>> = movieRepository.getAllMovies()

//    override fun getDetailMovie(id: Int): LiveData<Resource<Movie>> {
//    }

    override fun updateMovie(movie: Movie) = movieRepository.updateMovie(movie)

    override fun getFavoriteMovies(): LiveData<PagedList<Movie>> = movieRepository.getFavoriteMovies()
}