package com.gfb.watchlist.main.database.content

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContentDao {
    @Query("select * from DataBaseContent")
    fun getContent(): LiveData<List<DataBaseContent>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(content: List<DataBaseContent>)
}