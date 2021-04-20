package com.mirfanrafif.kicksfilm.ui.home

import com.mirfanrafif.kicksfilm.data.FilmData
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = HomeViewModel()
    }

    @Test
    fun getMovies() {
        val movies = viewModel.getMovies()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    @Test
    fun getDetailMovies() {
        val movies = viewModel.getMovies()
        assertNotNull(movies)
        assertEquals(10, movies.size)
        val movie = viewModel.getMovies()[0]
        assertEquals(FilmData.getMovies()[0], movie)
    }

    @Test
    fun getTvShows() {
        val movies = viewModel.getTvShows()
        assertNotNull(movies)
        assertEquals(8, movies.size)
    }

    @Test
    fun getDetailTvShow() {
        val movies = viewModel.getTvShows()
        assertNotNull(movies)
        assertEquals(8, movies.size)
        val movie = viewModel.getTvShows()[0]
        assertEquals(FilmData.getTVShows()[0], movie)
    }
}