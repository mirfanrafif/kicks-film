package com.mirfanrafif.kicksfilm.di

import com.mirfanrafif.kicksfilm.core.domain.usecase.MovieInteractor
import com.mirfanrafif.kicksfilm.core.domain.usecase.MovieUseCase
import com.mirfanrafif.kicksfilm.detail.DetailViewModel
import com.mirfanrafif.kicksfilm.favorite.FavoriteViewModel
import com.mirfanrafif.kicksfilm.movies.MoviesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MoviesViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}

val favoriteModule = module {
    viewModel { FavoriteViewModel(get()) }
}