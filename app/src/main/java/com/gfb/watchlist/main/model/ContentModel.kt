package com.gfb.watchlist.main.model

import com.gfb.watchlist.main.database.content.DataBaseContent
import com.squareup.moshi.Json
import java.io.Serializable

class ContentModel(
    @Json(name = "id")
    var id: String? = "",

    @Json(name = "Title")
    var title: String,

    @Json(name = "Year")
    var year: String,

    @Json(name = "Type")
    var type: String,

    @Json(name = "Poster")
    var poster: String,

    @Json(name = "Genre")
    var genre: String,

    @Json(name = "Director")
    var director: String,

    @Json(name = "Plot")
    var plot: String,

    @Json(name = "imdbID")
    var imdbID: String,

    @Json(name = "Actors")
    var actors: String,

    @Json(name = "Released")
    var released: String,

    @Json(name = "Production")
    var production: String,

    @Json(name = "Runtime")
    var runtime: String
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ContentModel

        if (imdbID != other.imdbID) return false

        return true
    }

    override fun hashCode(): Int {
        return imdbID.hashCode()
    }

}

fun List<ContentModel>.asDatabaseObject(): List<DataBaseContent> {
    return map {
        DataBaseContent(
            id = "it.id",
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
