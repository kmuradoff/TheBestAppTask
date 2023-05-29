package com.muradoff.thebestapptask.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.muradoff.thebestapptask.entity.FavoriteMovie

@Dao
interface MovieDao {
    //get all favorite movies
    @Query("SELECT * FROM favorite_movies")
    fun getAllFavoriteMovies(): List<FavoriteMovie?>?

    @Insert
    fun insertFavoriteMovie(favoriteMovie: FavoriteMovie)

    @Update
    fun updateFavoriteMovie(favoriteMovie: FavoriteMovie)

    @Delete
    fun deleteFavoriteMovie(favoriteMovie: FavoriteMovie)

    @Query("SELECT * FROM favorite_movies WHERE movieId = :id")
    fun getFavoriteMovieById(id: String?): FavoriteMovie?

    @Query("DELETE FROM favorite_movies WHERE movieId = :id")
    fun deleteFavoriteMovieById(id: String?)

    @Query("DELETE FROM favorite_movies")
    fun deleteAllFavoriteMovies()

    @Query("SELECT * FROM favorite_movies WHERE title LIKE :title")
    fun searchByTitle(title: String?): List<FavoriteMovie?>?

}