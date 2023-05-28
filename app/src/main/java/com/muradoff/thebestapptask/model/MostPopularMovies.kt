package com.muradoff.thebestapptask.model

import com.google.gson.annotations.SerializedName
import lombok.Data


@Data
data class MostPopularMovies(
    @SerializedName("id")
    override val id: String,
    @SerializedName("rank")
    val rank: String,
    @SerializedName("rankUpDown")
    val rankUpDown: String,
    @SerializedName("title")
    override val title: String,
    @SerializedName("fullTitle")
    val fullTitle: String,
    @SerializedName("year")
    val year: String,
    @SerializedName("image")
    override val image: String?,
    @SerializedName("crew")
    val crew: String,
    @SerializedName("imDbRating")
    val imDbRating: String,
    @SerializedName("imDbRatingCount")
    val imDbRatingCount: String
): Movie