package com.muradoff.thebestapptask.model.MovieDetail


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("key")
    val key: String,
    @SerializedName("value")
    val value: String
)