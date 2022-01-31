package com.compass.poc.samflix.model


data class DetailsMovie(
    val urlImage: String,
    val title: String,
    val popularity: String,
    val date: String,
    val runtime: String,
    val tagline: String?,
    val sinopse: String
)
