package com.gfb.watchlist.main.database.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("select * from DatabaseUser")
    fun getUser(): LiveData<List<DatabaseUser>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(content: List<DatabaseUser>)
}