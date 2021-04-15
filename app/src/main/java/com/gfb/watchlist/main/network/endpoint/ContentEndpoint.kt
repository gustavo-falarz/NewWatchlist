package com.gfb.watchlist.main.network.endpoint

import com.gfb.watchlist.main.model.ContentModel
import com.gfb.watchlist.main.model.ResultModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by Gustavo on 10/26/2017.
 */

interface ContentEndpoint {

    @POST("content/add")
    suspend fun addContent(@Body dto: ContentModel): ResultModel

    @POST("content/archive")
    suspend fun archiveContent(@Body dto: ContentModel): ResultModel

    @POST("content/delete")
    suspend fun deleteContent(@Body dto: ContentModel): ResultModel

    @GET("content/searchOnImdb/{param}")
    suspend fun searchOnImdb(@Path("param") param: String): List<ContentModel>

    @GET("content/findArchive/{userId}")
    suspend fun findArchive(@Path("userId") param: String): List<ContentModel>

    @GET("content/clearArchive/{userId}")
    suspend fun clearArchive(@Path("userId") param: String): ResultModel

    @POST("v1/content/find/{userId}")
    suspend fun findContent(@Path("userId") userId: String): MutableList<ContentModel>

    @GET("content/getContentDetails/{id}")
    suspend fun getContentDetails(@Path("id") param: String): ContentModel

}
