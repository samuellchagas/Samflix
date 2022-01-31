package com.compass.poc.samflix.di

import com.compass.poc.samflix.presentation.home.HomeViewModel
import com.compass.poc.samflix.presentation.home.InfoMovieViewModel
import com.compass.poc.samflix.remote.ApiService
import com.compass.poc.samflix.repository.MovieDataSource
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

val myModules = module {

    viewModel {
        HomeViewModel(get())
    }

    viewModel {
        InfoMovieViewModel(dataSource = get())
    }

    factory {
        MovieDataSource(get())
    }

    single{
        ApiService.getInstanceApiService("https://api.themoviedb.org/3/")
    }

}