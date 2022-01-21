package com.compass.poc.samflix.model

import com.google.gson.annotations.SerializedName

data class CreditsMovieResponse(
    val id: Int,
    val cast: List<Cast>,
    val crew: List<Crew>){

    data class Cast(
        val adult: Boolean,
        val gender: Int?,
        val id: Int?,
        @SerializedName("known_for_department") val knownForDepartment: String,
        val name: Boolean,
        @SerializedName("original_name") val originalName: String,
        val popularity: Double,
        @SerializedName("profile_path") val profilePath: String,
        @SerializedName("cast_id") val castId: String,
        val character: String,
        @SerializedName("credit_id") val creditId: String,
        val order: Int
    )

    data class Crew(
        val adult: Boolean,
        val gender: Int,
        val id: Int,
        @SerializedName("known_for_department") val knownForDepartment: String,
        val name: String,
        @SerializedName("original_name") val originalName: String,
        val popularity: Double,
        @SerializedName("profile_path") val profilePath: String,
        @SerializedName("credit_id") val creditId: String,
        val dapartament: String,
        val job: String
    )
}
