package com.example.junior

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimalApi {

    @GET("shibes")
    fun getShibes(
        @Query("count") count: Int,
        @Query("urls") urls: Boolean,
        @Query("httpsUrls") httpsUrls: Boolean
    ): Call<List<String>>
}
