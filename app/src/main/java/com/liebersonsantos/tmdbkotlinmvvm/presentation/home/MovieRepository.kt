package com.liebersonsantos.tmdbkotlinmvvm.presentation.home

import com.liebersonsantos.tmdbkotlinmvvm.data.ApiService
import com.liebersonsantos.tmdbkotlinmvvm.data.model.MovieResponse
import retrofit2.Call

class MovieRepository {

    fun getAllMovieList(apiKey: String): Call<MovieResponse>{
        return ApiService.service.getAllMoviesFromAPi(apiKey)
    }
}