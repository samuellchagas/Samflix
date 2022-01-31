package com.compass.poc.samflix.repository

import com.compass.poc.samflix.model.DetailsMovie
import com.compass.poc.samflix.model.MovieItemAdapter

interface MovieRepository {

    suspend fun getTopMovies(): List<MovieItemAdapter>
    suspend fun getDetailsMovie(movieId: String): DetailsMovie

}