package com.compass.poc.samflix.model

import com.google.gson.annotations.SerializedName

data class DetailsMovieResponse (
    val adult: Boolean,
    @SerializedName("background_path")val backdropPath: String?,
    val budget: Int,
    val genres:List<Genres>,
    val homePage: String?,
    val id: Int,
    @SerializedName("imdb_id") val imdbId:String?,
    @SerializedName("original_language") val originalLanguage:String,
    @SerializedName("original_title") val originalTitle:String,
    val overview: String?,
    val popularity: Double,
    @SerializedName("poster_path") val posterPath:String?,
    @SerializedName("production_companies") val productionCompanies: List<ProductionCompanies>,
    @SerializedName("production_countries") val productionCountries: List<ProductionCountries>,
    @SerializedName("release_date") val releaseDate: String,
    val revenue:Int,
    val runtime:Int?,
    @SerializedName("spoken_languages") val spokenLanguages: List<SpokenLanguages>,
    val status: String,
    val tagline: String?,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int,

    ){

    data class Genres(
        val id: Int,
        val name: String
    )

    data class ProductionCompanies(
        val name: String,
        val id: Int,
        @SerializedName("logo_path") val logoPath: String?,
        @SerializedName("origin_country") val originCountry: String,
    )

    data class ProductionCountries(
        @SerializedName("iso_3166_1") val iso31661: String,
        val name:String
    )

    data class SpokenLanguages(
        @SerializedName("iso_639_1") val iso6391: String,
        val name:String
    )
}