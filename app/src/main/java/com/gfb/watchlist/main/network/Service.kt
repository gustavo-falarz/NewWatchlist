package com.gfb.watchlist.main.network

import com.gfb.watchlist.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by Gustavo on 10/16/2017.
 */

object Service {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val builder = Retrofit.Builder()
        .baseUrl(BuildConfig.URL_BASE)
        .addConverterFactory(MoshiConverterFactory.create(moshi))


    fun <S> createService(serviceClass: Class<S>): S {
        val retrofit = builder
            .build()
        return retrofit.create(serviceClass)
    }

}
