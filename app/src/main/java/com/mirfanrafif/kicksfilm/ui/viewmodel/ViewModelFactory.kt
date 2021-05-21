package com.mirfanrafif.kicksfilm.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mirfanrafif.kicksfilm.domain.repository.MovieRepository
import com.mirfanrafif.kicksfilm.di.Injection
import com.mirfanrafif.kicksfilm.domain.usecase.MovieUseCase
import com.mirfanrafif.kicksfilm.ui.detail.DetailViewModel
import com.mirfanrafif.kicksfilm.ui.favorite.FavoriteViewModel
import com.mirfanrafif.kicksfilm.ui.movies.MoviesViewModel

class ViewModelFactory private constructor(private val movieUseCase: MovieUseCase): ViewModelProvider.NewInstanceFactory(){
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(Injection.provideUseCase(context)).apply {
                instance = this
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(movieUseCase) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(movieUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(movieUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}