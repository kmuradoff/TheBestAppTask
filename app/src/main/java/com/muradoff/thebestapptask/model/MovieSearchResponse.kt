package com.muradoff.thebestapptask.model

import com.google.gson.annotations.SerializedName
import lombok.Data

@Data
data class MovieSearchResponse(
    @SerializedName("searchType")
    val searchType: String,
    @SerializedName("expression")
    val expression: String,
    @SerializedName("results")
    val results: List<MovieSearch>
)