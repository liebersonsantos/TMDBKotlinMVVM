package com.liebersonsantos.tmdbkotlinmvvm.presentation.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liebersonsantos.tmdbkotlinmvvm.BuildConfig
import com.liebersonsantos.tmdbkotlinmvvm.R
import com.liebersonsantos.tmdbkotlinmvvm.data.model.MovieResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class HomeAdapter(
    val movies: List<MovieResult>,
    val itemClickListener: ((movieResult: MovieResult) -> Unit)
) : RecyclerView.Adapter<HomeAdapter.HomeAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return HomeAdapterViewHolder(itemView, itemClickListener)
    }

    override fun getItemCount() = movies.count()

    override fun onBindViewHolder(holder: HomeAdapterViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    class HomeAdapterViewHolder(
        itemView: View,
        private val itemClickListener: (movieResult: MovieResult) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val textNameMovie = itemView.textNameMovie
        private val textVoteAverage = itemView.textVoteAverage
        private val imageViewMovie = itemView.imageViewMovie
        private val textReleaseDate = itemView.textReleaseDate
        private val picasso = Picasso.get()

        fun bind(movie: MovieResult) {

            textNameMovie.text = movie.originalTitle
            textVoteAverage.text = movie.voteAverage.toString()
            textReleaseDate.text = movie.releaseDate

            movie.posterPath.let {
                picasso.load("""${BuildConfig.BASE_URL_IMAGE}${movie.posterPath}""")
                    .into(imageViewMovie)
            }

            itemView.setOnClickListener {
                itemClickListener.invoke(movie)
            }
        }

    }
}