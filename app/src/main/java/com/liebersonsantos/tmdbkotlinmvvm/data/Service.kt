package com.liebersonsantos.tmdbkotlinmvvm.data

import com.liebersonsantos.tmdbkotlinmvvm.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("movie/popular")
    fun getAllMoviesFromAPi(@Query("api_key") apiKey: String): Call<MovieResponse>
}