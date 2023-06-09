package com.muradoff.thebestapptask.model.MovieDetail


import com.google.gson.annotations.SerializedName

data class BoxOffice(
    @SerializedName("budget")
    val budget: String,
    @SerializedName("cumulativeWorldwideGross")
    val cumulativeWorldwideGross: String,
    @SerializedName("grossUSA")
    val grossUSA: String,
    @SerializedName("openingWeekendUSA")
    val openingWeekendUSA: String
)