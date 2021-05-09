package com.mirfanrafif.kicksfilm.ui.tvshow

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
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(movieRepository)
    }

    @Test
    fun getAllTvShow() {
        val dummyTvShow = FilmData.getTVShows()
        val tvShowList = MutableLiveData<List<MovieEntity>>()
        tvShowList.value = dummyTvShow
        Mockito.`when`(movieRepository.getAllTvShows()).thenReturn(tvShowList)

        val tvshows = viewModel.getAllTvShow().value
        verify(movieRepository).getAllTvShows()
        assertNotNull(tvshows)
    }
}