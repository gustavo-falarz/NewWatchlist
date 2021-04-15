package com.gfb.watchlist.main.model

class UserContentModel(
    var userId: String?,
    var content: ContentModel?,
    var type: Type?
) {

    constructor(userId: String?) : this(userId, null, null)

    constructor(userId: String?, content: ContentModel?) : this(userId, content, null)

    enum class Type {
        MOVIE,
        SERIES
    }
}