package com.muradoff.thebestapptask.model

import com.google.gson.annotations.SerializedName
import lombok.Data

@Data
data class MostPopularMoviesResponse(
    @SerializedName("items")
    val items: List<MostPopularMovies>
)