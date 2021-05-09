package com.mirfanrafif.kicksfilm.ui.detail

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
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<MovieEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository)
    }

    @Test
    fun getDetailMovie() {
        val dummyMovies = FilmData.getMovies()
        val movie = MutableLiveData<MovieEntity>()
        val id = dummyMovies[0].id
        movie.value = dummyMovies[0]
        Mockito.`when`(movieRepository.getDetailMovie(id)).thenReturn(movie)

        val movieEntity = viewModel.getDetailMovie(id, "movie").value
        verify(movieRepository).getDetailMovie(id)
        assertNotNull(movieEntity)

        viewModel.getDetailMovie(id, "movie").observeForever(observer)
        verify(observer).onChanged(dummyMovies[0])

    }
}