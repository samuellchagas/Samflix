package com.compass.poc.samflix.repository

import com.compass.poc.samflix.model.MovieItemAdapter
import com.compass.poc.samflix.remote.ApiService
import com.compass.poc.samflix.remote.ApiService.Companion.API_KEY
import com.compass.poc.samflix.remote.ApiService.Companion.LANGUAGE
import com.compass.poc.samflix.utils.HelperFuntions.mapTopMoviesResponseToMovieItemAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieDataSource(
    private val apiService: ApiService
): MovieRepository {

    override suspend fun getTopMovies(): List<MovieItemAdapter> {
            val responseTopMovies = apiService.getTopMovies(API_KEY, LANGUAGE)
            val responseGenresId = apiService.getGenreMovies(API_KEY, LANGUAGE)

            if(responseTopMovies.isSuccessful){
                return if(responseGenresId.isSuccessful){
                    mapTopMoviesResponseToMovieItemAdapter(data = responseTopMovies.body()!!, genreDictionary = responseGenresId.body()!!)
                }else{
                    mapTopMoviesResponseToMovieItemAdapter(data = responseTopMovies.body()!!, genreDictionary = null)
                }
            }else{
                throw Exception(MESSAGE_ERROR_GET_TOP_MOVIES)
            }
    }

    companion object{
        private const val MESSAGE_ERROR_GET_TOP_MOVIES =  "Erro ao carregar a lista de top filmes"
    }

}
