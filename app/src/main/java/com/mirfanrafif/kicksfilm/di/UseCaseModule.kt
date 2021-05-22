package com.mirfanrafif.kicksfilm.di

import com.mirfanrafif.kicksfilm.core.domain.usecase.MovieInteractor
import com.mirfanrafif.kicksfilm.ui.detail.DetailViewModel
import com.mirfanrafif.kicksfilm.ui.favorite.FavoriteViewModel
import com.mirfanrafif.kicksfilm.ui.movies.MoviesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MoviesViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}