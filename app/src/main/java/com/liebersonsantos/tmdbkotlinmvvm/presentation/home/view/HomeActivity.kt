package com.liebersonsantos.tmdbkotlinmvvm.presentation.home.view

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.liebersonsantos.tmdbkotlinmvvm.BuildConfig
import com.liebersonsantos.tmdbkotlinmvvm.R
import com.liebersonsantos.tmdbkotlinmvvm.presentation.baseActivity.BaseActivity
import com.liebersonsantos.tmdbkotlinmvvm.presentation.home.adapter.HomeAdapter
import com.liebersonsantos.tmdbkotlinmvvm.presentation.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*

class HomeActivity : BaseActivity() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupToolbar(toolbarMain, R.string.text_toolbar_home)

        viewModel.movieListLiveData.observe(this, Observer {
            it?.let { movieList ->
                with(recyclerViewHome) {
                    layoutManager = GridLayoutManager(this@HomeActivity, 2)
                    setHasFixedSize(true)
                    adapter = HomeAdapter(movieList){ movie ->
                        Toast.makeText(this@HomeActivity, "Detalhe do filme ${movie.originalTitle}", Toast.LENGTH_SHORT).show()

                    }
                }
            }

        })

        viewModel.getAllMovies(BuildConfig.API_KEY)
    }

}