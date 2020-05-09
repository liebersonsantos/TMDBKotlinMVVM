package com.liebersonsantos.tmdbkotlinmvvm.presentation.home.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liebersonsantos.tmdbkotlinmvvm.data.model.MovieResponse
import com.liebersonsantos.tmdbkotlinmvvm.data.model.MovieResult
import com.liebersonsantos.tmdbkotlinmvvm.presentation.home.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {

    val movieListLiveData: MutableLiveData<List<MovieResult>> = MutableLiveData()
    val repository = MovieRepository()

    fun getAllMovies(apiKey: String){
        repository.getAllMovieList(apiKey).enqueue(object: Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                when{
                    response.isSuccessful ->{
                        response.body()?.let {
                            movieListLiveData.value = it.movieResult
                        }
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(HomeViewModel::class.java.simpleName, " --> ${t.message}")
            }

        })
    }

}