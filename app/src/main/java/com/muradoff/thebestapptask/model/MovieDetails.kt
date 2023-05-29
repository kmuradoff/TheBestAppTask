package com.muradoff.thebestapptask.model

import com.google.gson.annotations.SerializedName
import lombok.Data

@Data
data class MovieDetails (
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("plot")
    val plot: String,
    @SerializedName("ratings.imDb")
    val ratingImdb: String,
    @SerializedName("releaseDate")
    val releaseDate: String,
    @SerializedName("trailer")
    val trailer: String
)