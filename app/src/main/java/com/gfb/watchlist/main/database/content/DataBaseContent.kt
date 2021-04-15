package com.gfb.watchlist.main.database.content

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gfb.watchlist.main.model.ContentModel

@Entity
data class DataBaseContent constructor(
    var id: String,
    var title: String,
    var year: String,
    var type: String,
    var poster: String,
    var genre: String,
    var director: String,
    var plot: String,
    @PrimaryKey
    var imdbID: String,
    var actors: String,
    var released: String,
    var production: String,
    var runtime: String
)


fun List<DataBaseContent>.asDomainModel(): List<ContentModel> {
    return map {
        ContentModel(
            id = it.id,
            title = it.title,
            year = it.year,
            type = it.type,
            poster = it.poster,
            genre = it.genre,
            director = it.director,
            plot = it.plot,
            imdbID = it.imdbID,
            actors = it.actors,
            released = it.released,
            production = it.production,
            runtime = it.runtime
        )
    }
}