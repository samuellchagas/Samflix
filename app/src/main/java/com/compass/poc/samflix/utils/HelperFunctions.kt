package com.compass.poc.samflix.utils

import com.compass.poc.samflix.model.*

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
                date = topMoviesResponse.releaseDate.substring(0,4),
                id = topMoviesResponse.id.toString()
            )
        }
    }

    fun mapGenreListIdsToFormatGenreNames(
        genresId: List<Int>,
        genreDictionary: GenreMoviesResponse
    ): String {
        var genresStringFormat = ""
        genresId.forEach { id ->
            genreDictionary.genres.forEach { genre ->
                if (genre.id == id) {
                    genresStringFormat += "${genre.name},"
                }
            }
        }
        return genresStringFormat
            .substring(0, genresStringFormat.length - 1)
            .replace(",", ", ")
    }

    fun mapDetailsMovieResponseToDetailsMovie(data: DetailsMovieResponse): DetailsMovie {
        return DetailsMovie(
            urlImage = BASE_URL_IMAGE + data.backdropPath,
            title = data.title,
            popularity = "${(data.voteAverage*10).toInt()}% relevante",
            runtime = "${data.runtime/60}h ${data.runtime%60}m",
            tagline = data.tagline ?: "",
            date = data.releaseDate.substring(0, 4),
            sinopse = data.overview
        )
    }

    const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w500/"

}