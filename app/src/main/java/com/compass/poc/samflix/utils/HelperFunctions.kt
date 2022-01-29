package com.compass.poc.samflix.utils

import com.compass.poc.samflix.model.GenreMoviesResponse
import com.compass.poc.samflix.model.MovieItemAdapter
import com.compass.poc.samflix.model.TopMoviesResponse

object HelperFuntions {

    fun mapTopMoviesResponseToMovieItemAdapter(
        data: TopMoviesResponse,
        genreDictionary: GenreMoviesResponse?
    ): List<MovieItemAdapter> {
        return data.results.map { topMoviesResponse ->
            MovieItemAdapter(
                urlImage = BASE_URL_IMAGE + topMoviesResponse.posterPath,
                title = topMoviesResponse.title,
                genres = if (genreDictionary == null) {
                    ""
                } else {
                    mapGenreListIdsToFormatGenreNames(
                        genresId = topMoviesResponse.genreIds,
                        genreDictionary = genreDictionary
                    )
                },
                date = topMoviesResponse.releaseDate.substring(0,4)
            )
        }
    }

    fun mapGenreListIdsToFormatGenreNames(
        genresId: List<Int>,
        genreDictionary: GenreMoviesResponse
    ): String {
        var genresStringFormat = ""
        var countNumberGenres = 0
        genresId.forEach { id ->
            genreDictionary.genres.forEach { genre ->
                if (genre.id == id) {
                    genresStringFormat = "${genre.name} "
                    countNumberGenres++
                }
            }
        }
        return if (countNumberGenres == 1) {
            genresStringFormat
        }else{
            genresStringFormat.replace(oldValue = " ", newValue = ", ")
        }
    }

    const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w500/"

}