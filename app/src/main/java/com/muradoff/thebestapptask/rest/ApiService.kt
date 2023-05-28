package com.muradoff.thebestapptask.rest

import com.muradoff.thebestapptask.model.MostPopularMoviesResponse
import com.muradoff.thebestapptask.model.MovieSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    //@GET("/en/API/SearchTitle/k_m0v3ekd3/{expression}")
    @GET("/en/API/SearchTitle/k_m8yuu95f/{expression}")
    fun searchMovies(@Path("expression") expression: String): Call<MovieSearchResponse>

    //@GET("/en/API/MostPopularMovies/k_m0v3ekd3")
    @GET("/en/API/MostPopularMovies/k_m8yuu95f")
    fun fetchMostPopularMovies(): Call<MostPopularMoviesResponse>
}
