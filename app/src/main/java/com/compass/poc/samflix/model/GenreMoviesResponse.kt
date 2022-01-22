package com.compass.poc.samflix.model

data class GenreMoviesResponse(
    val genres: List<GenreId>
) {
    data class GenreId(
        val id: Int,
        val name: String
    )
}