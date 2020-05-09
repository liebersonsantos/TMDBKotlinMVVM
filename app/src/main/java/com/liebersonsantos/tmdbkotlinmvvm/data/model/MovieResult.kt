package com.liebersonsantos.tmdbkotlinmvvm.data.model

import com.google.gson.annotations.SerializedName

data class MovieResult (

    @SerializedName("id")
    val id: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String
)