package com.compass.poc.samflix.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compass.poc.samflix.model.MovieItemAdapter
import com.compass.poc.samflix.repository.MovieDataSource
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel(private val dataSource: MovieDataSource): ViewModel() {

    private val _sucessResponseListTopMovies = MutableLiveData<List<MovieItemAdapter>>()
    val sucessResponseListTopMovies: LiveData<List<MovieItemAdapter>> = _sucessResponseListTopMovies

    private val _errorResponseListTopMovies = MutableLiveData<String>()
    val errorResponseListTopMovies: LiveData<String> = _errorResponseListTopMovies

    fun getTopMovies() {
        viewModelScope.launch {
            try {
                val response = dataSource.getTopMovies()
                _sucessResponseListTopMovies.postValue(response)
            }catch (e: Exception){
                _errorResponseListTopMovies.postValue(e.message)
            }
        }
    }

}