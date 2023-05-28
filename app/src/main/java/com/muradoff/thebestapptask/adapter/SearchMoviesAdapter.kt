package com.muradoff.thebestapptask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muradoff.thebestapptask.R
import com.muradoff.thebestapptask.model.MovieSearch


class SearchMoviesAdapter(
    var movies: List<MovieSearch>,
    private val onFavoriteClicked: (MovieSearch) -> Unit
) : RecyclerView.Adapter<SearchMoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title)
        private val ratingTextView: TextView = itemView.findViewById(R.id.imdbRating)
        private val favoriteButton: Button = itemView.findViewById(R.id.favorite)
        private val previewImageView: ImageView = itemView.findViewById(R.id.preview)

        fun bind(movie: MovieSearch) {
            titleTextView.text = movie.title
            ratingTextView.text = movie.description
            favoriteButton.setOnClickListener { onFavoriteClicked(movie) }
            Glide.with(itemView)
                .load(movie.image)
                .centerCrop()
                .into(previewImageView)
        }
    }
}