package com.mirfanrafif.kicksfilm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mirfanrafif.kicksfilm.data.MovieRepository
import com.mirfanrafif.kicksfilm.di.Injection
import com.mirfanrafif.kicksfilm.ui.detail.DetailViewModel
import com.mirfanrafif.kicksfilm.ui.movies.MoviesViewModel
import com.mirfanrafif.kicksfilm.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val movieRepository: MovieRepository): ViewModelProvider.NewInstanceFactory(){
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(Injection.provideRepository()).apply {
                instance = this
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(movieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}