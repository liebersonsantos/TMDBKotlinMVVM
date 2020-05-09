package com.liebersonsantos.tmdbkotlinmvvm.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("results")
    val movieResult: List<MovieResult>
)