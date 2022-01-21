package com.compass.poc.samflix.remote

import com.compass.poc.samflix.model.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/top_rated")
    suspend fun getTopMovies(
        @Query("api_key")apiKey:String,
        @Query("language")language:String
    ):Response<TopMoviesResponse>

    @GET("genre/movie/list")
    suspend fun getGenreMovies(
        @Query("api_key")apiKey:String,
        @Query("language")language:String
    ):Response<GenreMoviesResponse>

    @GET("movie/{movie_id}")
    suspend fun getDetailsMovie(
        @Path("movie_id")movieId: String,
        @Query("api_key")apiKey:String,
        @Query("language")language:String
    ):Response<DetailsMovieResponse>

    @GET("movie/{movie_id}/recommendations")
    suspend fun getRecomendMovies(
        @Path("movie_id")movieId: String,
        @Query("api_key")apiKey:String,
        @Query("language")language:String
    ):Response<RecomendMoviesResponse>

    @GET("movie/{movie_id}/credits")
    suspend fun getCreditMovie(
        @Path("movie_id")movieId: String,
        @Query("api_key")apiKey:String,
        @Query("language")language:String
    ):Response<CreditsMovieResponse>

    @GET("movie/{movie_id}/reviews")
    suspend fun getReviewsMovie(
        @Path("movie_id")movieId: String,
        @Query("api_key")apiKey:String,
        @Query("language")language:String
    ):Response<ReviewsMovieResponse>

    companion object {
        fun getInstanceApiService(baseURL: String): ApiService {
            return Retrofit.Builder().baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }

        private const val API_KEY = "76f8c50946ae21b6a15ed98a60e76d53"
        private const val LANGUAGE = "pt-BR"
    }

}
