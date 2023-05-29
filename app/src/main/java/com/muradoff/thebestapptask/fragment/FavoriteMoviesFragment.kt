package com.muradoff.thebestapptask.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muradoff.thebestapptask.R
import com.muradoff.thebestapptask.adapter.FavoriteMoviesAdapter
import com.muradoff.thebestapptask.db.MovieDatabase
import com.muradoff.thebestapptask.entity.FavoriteMovie
import com.muradoff.thebestapptask.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FavoriteMoviesFragment : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var favMovies: MutableList<Movie> = ArrayList()
    private var backButton: Button? = null
    private var progressBar: ProgressBar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflater = inflater.inflate(R.layout.fragment_favorite_movies, container, false)

        recyclerView = inflater.findViewById(R.id.recyclerView)
        progressBar = inflater.findViewById(R.id.favoriteProgressBar)
        backButton = inflater.findViewById(R.id.backButton)



        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager

        GlobalScope.launch(Dispatchers.Main) {

            fetchFavoriteMovies()
        }

        backButton?.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_favoriteMoviesFragment_to_movieListFragment)
        }

        return inflater
    }


    //create a function that fetches all the favorite movies from the database
    private suspend fun fetchFavoriteMovies() {
        mAdapter = FavoriteMoviesAdapter(favMovies as MutableList<FavoriteMovie>)
        recyclerView.adapter = mAdapter
        val movieDb: MovieDatabase = MovieDatabase.getDatabase(this.context)
        GlobalScope.launch(Dispatchers.Main) {
            val favoriteMovies = getAllFavoriteMovies()
            favMovies.addAll(favoriteMovies as MutableList<Movie>)
            progressBar?.visibility = View.GONE
            mAdapter!!.notifyDataSetChanged()
        }
    }

    private suspend fun getAllFavoriteMovies(): List<FavoriteMovie?>? {
        val movieDb: MovieDatabase = MovieDatabase.getDatabase(this.context)
        return withContext(Dispatchers.IO) {
            movieDb.movieDao()?.getAllFavoriteMovies()
        }
    }
}