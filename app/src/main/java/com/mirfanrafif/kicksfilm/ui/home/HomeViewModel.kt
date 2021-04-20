package com.mirfanrafif.kicksfilm.ui.home

import androidx.lifecycle.ViewModel
import com.mirfanrafif.kicksfilm.data.FilmData
import com.mirfanrafif.kicksfilm.data.Movie

class HomeViewModel : ViewModel(){
    fun getMovies(): List<Movie> {
        return FilmData.getMovies()
    }

    fun getTvShows(): List<Movie> {
        return FilmData.getTVShows()
    }
}