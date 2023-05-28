package com.muradoff.thebestapptask.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muradoff.thebestapptask.R
import com.muradoff.thebestapptask.adapter.MostPopularMoviesAdapter
import com.muradoff.thebestapptask.adapter.SearchMoviesAdapter
import com.muradoff.thebestapptask.model.MostPopularMovies
import com.muradoff.thebestapptask.model.MostPopularMoviesResponse
import com.muradoff.thebestapptask.model.Movie
import com.muradoff.thebestapptask.model.MovieSearch
import com.muradoff.thebestapptask.model.MovieSearchResponse
import com.muradoff.thebestapptask.rest.ApiService
import com.muradoff.thebestapptask.rest.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var mApiService: ApiService? = null
    private lateinit var searchEditText: EditText
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var popularMovies: MutableList<MostPopularMovies> = ArrayList()
    private var searchMovies: MutableList<MovieSearch> = ArrayList()
    private var progressBar: ProgressBar? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var inflater = inflater.inflate(R.layout.fragment_movie_list, container, false)

        recyclerView = inflater.findViewById<RecyclerView>(R.id.recyclerView)
        searchEditText = inflater.findViewById(R.id.titleSearchText)
        progressBar = inflater.findViewById(R.id.progressBar)


        searchEditText.setOnEditorActionListener { v, actionId, event ->
            if (searchEditText.text.isEmpty()) fetchPopularMovies()
            else fetchMoviesByTitle(searchEditText.text.toString())
            true
        }

        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        fetchPopularMovies()

        return inflater
    }

    private fun onFavoriteClicked(movie: Movie) {
        println(movie)
        println("onFavoriteClicked")
    }

    private fun fetchMoviesByTitle(title: String) {
        progressBar?.visibility = View.VISIBLE
        mAdapter = SearchMoviesAdapter(searchMovies) { movie -> onFavoriteClicked(movie) }
        searchMovies.clear()
        recyclerView.adapter = mAdapter
        mApiService = RestClient.client.create(ApiService::class.java)
        val call = mApiService!!.searchMovies(title)
        call.enqueue(object : Callback<MovieSearchResponse> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<MovieSearchResponse>, response: Response<MovieSearchResponse>
            ) {
                searchMovies.addAll(response.body()!!.results)
                println(searchMovies)
                progressBar?.visibility = View.GONE
                mAdapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<MovieSearchResponse>, t: Throwable) {
                println("bad")
            }

        })
    }

    private fun fetchPopularMovies() {
        progressBar?.visibility = View.VISIBLE
        mAdapter = MostPopularMoviesAdapter(popularMovies) { movie -> onFavoriteClicked(movie) }
        recyclerView.adapter = mAdapter
        mApiService = RestClient.client.create(ApiService::class.java)
        val call = mApiService!!.fetchMostPopularMovies()
        call.enqueue(object : Callback<MostPopularMoviesResponse> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<MostPopularMoviesResponse>, response: Response<MostPopularMoviesResponse>
            ) {
                popularMovies.addAll(response.body()!!.items)
                println(popularMovies)
                progressBar?.visibility = View.GONE
                mAdapter!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<MostPopularMoviesResponse>, t: Throwable) {
                println("bad")
            }

        })
    }
}

