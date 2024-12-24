package com.example.multiviewholder

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("api/ns/store/unsec/v1/getNearByStores")
    fun getData(
        @Query("page") page: Int = 0,
        @Query("pageSize") pageSize: Int = 100,
        @Query("latitude") latitude: Double = 28.59178,
        @Query("longitude") longitude: Double = 77.3189613
    ): Call<ApiData>
}

