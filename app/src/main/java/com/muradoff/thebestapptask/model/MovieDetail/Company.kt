package com.muradoff.thebestapptask.model.MovieDetail


import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)