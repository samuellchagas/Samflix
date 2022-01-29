package com.compass.poc.samflix.repository

import com.compass.poc.samflix.model.MovieItemAdapter

interface MovieRepository {

    suspend fun getTopMovies(): List<MovieItemAdapter>

}