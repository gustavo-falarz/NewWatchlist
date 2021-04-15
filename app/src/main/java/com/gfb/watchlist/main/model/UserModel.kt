package com.gfb.watchlist.main.model
import java.io.Serializable


class UserModel(
    var id: String,
    var email: String,
    var password: String,
    var status: Status,
    var watchList: List<ContentModel>,
    var archive: List<ContentModel>
) : Serializable {

    enum class Status {
        PENDING,
        PENDING_RESET,
        ACTIVE
    }
}