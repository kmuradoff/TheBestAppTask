package com.muradoff.thebestapptask.model.MovieDetail


import com.google.gson.annotations.SerializedName

data class Ratings(
    @SerializedName("errorMessage")
    val errorMessage: String,
    @SerializedName("filmAffinity")
    val filmAffinity: String,
    @SerializedName("fullTitle")
    val fullTitle: String,
    @SerializedName("imDb")
    val imDb: String,
    @SerializedName("imDbId")
    val imDbId: String,
    @SerializedName("metacritic")
    val metacritic: String,
    @SerializedName("rottenTomatoes")
    val rottenTomatoes: String,
    @SerializedName("theMovieDb")
    val theMovieDb: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("year")
    val year: String
)