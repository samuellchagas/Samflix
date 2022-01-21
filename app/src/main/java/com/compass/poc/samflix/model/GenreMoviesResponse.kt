package com.compass.poc.samflix.model

data class GenreMoviesResponse(
    val genres: List<Genres>
) {
    data class Genres(
        val id: Int,
        val name: String
    )
}
