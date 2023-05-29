package com.muradoff.thebestapptask.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.muradoff.thebestapptask.R
import com.muradoff.thebestapptask.model.MovieDetail.MovieIdDetail
import com.muradoff.thebestapptask.model.MovieDetails
import com.muradoff.thebestapptask.model.MovieSearchResponse
import com.muradoff.thebestapptask.rest.ApiService
import com.muradoff.thebestapptask.rest.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsFragment : Fragment() {
    private var mApiService: ApiService? = null

    private var imagePreviewImageView: ImageView? = null
    private var movieTitleTextView: TextView? = null
    private var moviePlotTextView: TextView? = null
    private var ratingImdbTextView: TextView? = null
    private var releaseDateTextView: TextView? = null
    private var addToFavoritesButton: Button? = null
    private var youtubeTrailerButton: Button? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val inflater = inflater.inflate(R.layout.fragment_movie_details, container, false)

        imagePreviewImageView = inflater.findViewById(R.id.imagePreviewImageView)
        movieTitleTextView = inflater.findViewById(R.id.movieTitleTextView)
        moviePlotTextView = inflater.findViewById(R.id.moviePlotTextView)
        ratingImdbTextView = inflater.findViewById(R.id.ratingImdbTextView)
        releaseDateTextView = inflater.findViewById(R.id.releaseDateTextView)
        addToFavoritesButton = inflater.findViewById(R.id.addToFavoritesButton)
        youtubeTrailerButton = inflater.findViewById(R.id.youtubeTrailerButton)


        return inflater
    }

    fun setMovieDetails(movieId: String) {
        mApiService = RestClient.client.create(ApiService::class.java)
        val call = mApiService!!.fetchMovieDetails(movieId)

        call.enqueue(object : Callback<MovieIdDetail> {
            override fun onResponse(call: Call<MovieIdDetail>, response: Response<MovieIdDetail>) {
                val movieDetails = response.body()
                if (movieDetails != null) {
                    imagePreviewImageView?.setImageURI(movieDetails.image.toUri())
                    movieTitleTextView?.text = movieDetails.title
                    moviePlotTextView?.text = movieDetails.plot
                    ratingImdbTextView?.text = movieDetails.ratings.imDb
                    releaseDateTextView?.text = movieDetails.releaseDate
                }
            }
            override fun onFailure(call: Call<MovieIdDetail>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}
