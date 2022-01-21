package com.compass.poc.samflix.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.net.URL

interface ApiService {

    @GET("movie/top_rated")
    suspend fun getTopMovies(
        @Query("api_key")apiKey:String,
        @Query("language")language:String
    ):Response<Any>

    @GET("genre/movie/list")
    suspend fun getGenreMovies(
        @Query("api_key")apiKey:String,
        @Query("language")language:String
    ):Response<Any>

    @GET("movie/{movie_id}")
    suspend fun getDetailsMovie(
        @Path("movie_id")movieId: String,
        @Query("api_key")apiKey:String,
        @Query("language")language:String
    ):Response<Any>

    @GET("movie/{movie_id}/recommendations")
    suspend fun getRecomendMovies(
        @Path("movie_id")movieId: String,
        @Query("api_key")apiKey:String,
        @Query("language")language:String
    ):Response<Any>

    @GET("movie/{movie_id}/credits")
    suspend fun getCreditMovie(
        @Path("movie_id")movieId: String,
        @Query("api_key")apiKey:String,
        @Query("language")language:String
    ):Response<Any>

    @GET("movie/{movie_id}/reviews")
    suspend fun getReviewsMovie(
        @Path("movie_id")movieId: String,
        @Query("api_key")apiKey:String,
        @Query("language")language:String
    ):Response<Any>

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
