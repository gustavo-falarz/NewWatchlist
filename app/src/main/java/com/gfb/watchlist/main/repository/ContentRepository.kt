package com.gfb.watchlist.main.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.gfb.watchlist.main.database.WatchListDatabase
import com.gfb.watchlist.main.database.content.asDomainModel
import com.gfb.watchlist.main.model.ContentModel
import com.gfb.watchlist.main.model.asDatabaseObject
import com.gfb.watchlist.main.network.Service
import com.gfb.watchlist.main.network.endpoint.ContentEndpoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ContentRepository(private val database: WatchListDatabase) {

    val content: LiveData<List<ContentModel>> =
        Transformations.map(database.contentDao.getContent()) {
            it.asDomainModel()
        }

    suspend fun refreshContent() {
        withContext(Dispatchers.IO) {
            val content = Service.createService(ContentEndpoint::class.java)
                .findContent(userId = "60086b6017ac130004f4f14f")

            val databaseContent = content.asDatabaseObject()
            database.contentDao.insertAll(content = databaseContent)
        }
    }

}