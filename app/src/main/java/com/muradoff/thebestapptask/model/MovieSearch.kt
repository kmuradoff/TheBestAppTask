package com.muradoff.thebestapptask.model

import com.google.gson.annotations.SerializedName
import lombok.Data

@Data
data class MovieSearch(
    @SerializedName("id")
    override val id: String,
    @SerializedName("resultType")
    val resultType: String,
    @SerializedName("image")
    override val image: String?,
    @SerializedName("title")
    override val title: String,
    @SerializedName("description")
    val description: String
): Movie