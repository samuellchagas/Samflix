package com.compass.poc.samflix.di

import com.compass.poc.samflix.remote.ApiService
import org.koin.core.context.startKoin
import org.koin.dsl.module

val myModules = module {

    single{
        ApiService
    }

}