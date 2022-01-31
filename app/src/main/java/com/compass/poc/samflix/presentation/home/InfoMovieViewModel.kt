package com.compass.poc.samflix.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compass.poc.samflix.model.DetailsMovie
import com.compass.poc.samflix.repository.MovieDataSource
import kotlinx.coroutines.launch

class InfoMovieViewModel(
    private val dataSource: MovieDataSource
) : ViewModel() {

    private val _sucessResponseDetailsMovie = MutableLiveData<DetailsMovie>()
    val sucessResponseDetailsMovie: LiveData<DetailsMovie> = _sucessResponseDetailsMovie

    private val _errorResponseDetailsMovie = MutableLiveData<String>()
    val errorResponseDetailsMovie: LiveData<String> = _errorResponseDetailsMovie

    private val _errorGenericApp = MutableLiveData<String>()
    val errorGenericApp: LiveData<String> = _errorGenericApp

    private val _errorDisconnectInternet = MutableLiveData<String>()
    val errorDisconnectInternet: LiveData<String> = _errorDisconnectInternet

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getDetailsMovie(movieId: String) {
        viewModelScope.launch {
            _loading.postValue(true)
                try {
                    val response = dataSource.getDetailsMovie(movieId = movieId)
                    _sucessResponseDetailsMovie.postValue(response)
                } catch (e: Exception) {
                    _errorGenericApp.postValue(MESSAGE_ERROR_GENERIC_APP)
                }
            _loading.postValue(false)
        }
    }


    companion object {
        private const val MESSAGE_ERROR_GET_DETAILS_MOVIE = "Erro ao carregar detalhes do filme"
        private const val MESSAGE_ERROR_GET_RECOMEND_MOVIES =
            "Erro ao carregar os filmes recomendados"
        private const val MESSAGE_ERROR_GET_CREDITS_MOVIE = "Erro ao carregar os creditos do filme"
        private const val MESSAGE_ERROR_GET_REVIEWS_MOVIE = "Erro ao carregar reviews do filme"
        private const val MESSAGE_ERROR_NO_CONNECTION_INTERNET = "Não a conexão de internet"
        private const val MESSAGE_ERROR_GENERIC_APP = "Ops... Algo inesperado aconteceu"
    }

}