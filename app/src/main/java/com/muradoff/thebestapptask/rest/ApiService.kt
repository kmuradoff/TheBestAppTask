package com.muradoff.thebestapptask.rest

import com.muradoff.thebestapptask.model.MostPopularMoviesResponse
import com.muradoff.thebestapptask.model.MovieDetail.MovieIdDetail
import com.muradoff.thebestapptask.model.MovieDetails
import com.muradoff.thebestapptask.model.MovieSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    //@GET("/en/API/SearchTitle/k_m0v3ekd3/{expression}")
    //@GET("/en/API/SearchTitle/k_m8yuu95f/{expression}")
    @GET("/en/API/SearchTitle/k_mw9ealpg/{expression}")
    fun searchMovies(@Path("expression") expression: String): Call<MovieSearchResponse>

    //@GET("/en/API/MostPopularMovies/k_m0v3ekd3")
    //@GET("/en/API/MostPopularMovies/k_m8yuu95f")
    @GET("/en/API/MostPopularMovies/k_mw9ealpg")
    fun fetchMostPopularMovies(): Call<MostPopularMoviesResponse>


    //@GET("en/API/Title/k_m0v3ekd3/tt1375666/FullActor,Ratings,")
    //@GET("en/API/Title/k_m8yuu95f/tt1375666/FullActor,Ratings,")
    @GET("en/API/Title/k_mw9ealpg/{movieId}/FullActor,Ratings,")
    fun fetchMovieDetails(@Path("movieId") movieId: String): Call<MovieIdDetail>
}
