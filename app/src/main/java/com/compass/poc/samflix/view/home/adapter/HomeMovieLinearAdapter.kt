package com.compass.poc.samflix.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.compass.poc.samflix.R
import com.compass.poc.samflix.model.MovieItemAdapter
import com.squareup.picasso.Picasso

class HomeMovieLinearAdapter(
    private val movieHomeClickListener: HomeMovieClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listMovies = mutableListOf<MovieItemAdapter>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeMovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_home, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeMovieViewHolder) {
            holder.bind(listMovies[position])
            holder.itemView.setOnClickListener {
                movieHomeClickListener.movieClickedListener(listMovies[position])
            }
        }
    }

    override fun getItemCount(): Int = listMovies.size

    fun setData(data: List<MovieItemAdapter>) {
        listMovies.addAll(data)
        notifyDataSetChanged()
    }

    class HomeMovieViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        private val imageMovie = itemview.findViewById<ImageView>(R.id.image_movie)
        private val titleMovie = itemview.findViewById<TextView>(R.id.title_movie)
        private val genresMovie = itemview.findViewById<TextView>(R.id.genres_movie)
        private val dataMovie = itemview.findViewById<TextView>(R.id.date_movie)

        fun bind(data: MovieItemAdapter) {
            Picasso.get().load(data.urlImage).into(imageMovie)
            titleMovie.text = data.title
            genresMovie.text = data.genres
            dataMovie.text = data.date
        }
    }

    interface HomeMovieClickListener {
        fun movieClickedListener(data: MovieItemAdapter)
    }
}