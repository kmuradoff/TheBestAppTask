package com.muradoff.thebestapptask.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.muradoff.thebestapptask.dao.MovieDao
import com.muradoff.thebestapptask.entity.FavoriteMovie

@Database(entities = [FavoriteMovie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao?

    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null
        fun getDatabase(context: Context?): MovieDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context!!.applicationContext,
                    MovieDatabase::class.java,
                    "movies_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}