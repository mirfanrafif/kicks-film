package com.mirfanrafif.kicksfilm.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.mirfanrafif.kicksfilm.data.FilmData
import com.mirfanrafif.kicksfilm.data.MovieRepository
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(movieRepository)
    }

    @Test
    fun getAllMovies() {
        val dummyMovies = FilmData.getMovies()
        val moviesList = MutableLiveData<List<MovieEntity>>()
        moviesList.value = dummyMovies
        `when`(movieRepository.getAllMovies()).thenReturn(moviesList)

        val movies = viewModel.getAllMovies().value
        verify(movieRepository).getAllMovies()
        assertNotNull(movies)

        viewModel.getAllMovies().observeForever(observer)
        verify(observer).onChanged(moviesList.value)
    }
}