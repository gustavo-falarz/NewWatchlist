package com.gfb.watchlist.main.database.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatabaseUser constructor(
    @PrimaryKey
    var id: String
)
