package com.gfb.watchlist.main.network.endpoint

import com.gfb.watchlist.main.model.AuthModel
import com.gfb.watchlist.main.model.ResultModel
import com.gfb.watchlist.main.model.UserModel
import retrofit2.http.Body
import retrofit2.http.POST


/**
 * Created by Gustavo on 12/26/2017.
 */
interface UserEndpoint {

    @POST("user/add")
    fun addUser(@Body user: AuthModel): ResultModel

    @POST("user/validate")
    fun signIn(@Body user: AuthModel): UserModel

    @POST("user/changePassword")
    fun changePassword(@Body user: AuthModel): UserModel

    @POST("user/forgotPassword")
    fun forgotPassword(@Body user: AuthModel): ResultModel

    @POST("user/googleSignIn")
    fun googleSignIn(@Body user: AuthModel): UserModel
}
