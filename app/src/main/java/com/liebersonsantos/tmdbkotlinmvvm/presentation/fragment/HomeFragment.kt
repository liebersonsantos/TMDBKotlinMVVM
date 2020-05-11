package com.liebersonsantos.tmdbkotlinmvvm.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.liebersonsantos.tmdbkotlinmvvm.BuildConfig
import com.liebersonsantos.tmdbkotlinmvvm.R
import com.liebersonsantos.tmdbkotlinmvvm.presentation.fragment.adapter.HomeFragmentAdapter
import com.liebersonsantos.tmdbkotlinmvvm.presentation.home.viewmodel.HomeFragmentViewModel
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    private val viewModel: HomeFragmentViewModel by lazy {
        ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let { fragemntActivity ->
            viewModel.movieListLiveData.observe(fragemntActivity, Observer {
                it?.let { movieList ->
                    with(recyclerViewHome) {
                        layoutManager = GridLayoutManager(fragemntActivity, 2)
                        setHasFixedSize(true)
                        adapter = HomeFragmentAdapter(movieList) { movie ->
                            Toast.makeText(
                                fragemntActivity,
                                "Detalhe do filme ${movie.originalTitle}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            })
        }

        viewModel.getAllMovies(BuildConfig.API_KEY)

    }

}
