package com.compass.poc.samflix.model

import com.google.gson.annotations.SerializedName

data class ReviewsMovieResponse(

    val id: Int,
    val page: Int,
    val results:List<Results>,
    @SerializedName("total_pages") val totalPages:Int,
    @SerializedName("total_results") val totalResults:Int,
){
    data class Results(
        val author:String,
        @SerializedName("author_details") val authorDetails: List<AuthorDetails>,
        val content: String,
        @SerializedName("created_at") val createdAt:String,
        val id: String,
        @SerializedName("updated_at") val updatedAt:String,
        val url: String

    )

    data class AuthorDetails(
        val name: String,
        val username: String,
        @SerializedName("avatar_path") val avatarPath:String?,
        val rating: Int?
    )


}
