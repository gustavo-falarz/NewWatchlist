package com.gfb.watchlist.main.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gfb.watchlist.main.database.content.ContentDao
import com.gfb.watchlist.main.database.content.DataBaseContent
import com.gfb.watchlist.main.database.user.DatabaseUser
import com.gfb.watchlist.main.database.user.UserDao

@Database(entities = [DataBaseContent::class, DatabaseUser::class], version = 1)
abstract class WatchListDatabase : RoomDatabase() {
    abstract val contentDao: ContentDao
    abstract val userDao: UserDao
}

private lateinit var INSTANCE: WatchListDatabase

fun getDatabase(context: Context): WatchListDatabase {
    synchronized(WatchListDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                WatchListDatabase::class.java,
                "content"
            ).build()
        }
    }
    return INSTANCE
}