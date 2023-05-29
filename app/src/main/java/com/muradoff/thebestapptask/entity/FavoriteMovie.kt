package com.muradoff.thebestapptask.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import lombok.Data

@Entity(tableName = "favorite_movies")
@Data
data class FavoriteMovie (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "movieId")
    val movieId: String?,
    @ColumnInfo(name = "imageUri")
    val imageUri: String?
)