package com.example.retrofitmarvel.data.domain.repository.remote

import com.example.retrofitmarvel.data.domain.repository.remote.response.MarvelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApiService {
    @GET("v1/public/characters?apikey=0c226ab4857fcefdf1261eeb56d8b098&hash=ad375ed1da237238bd37ead5c84f859d&ts=kotlin.Unit")
    suspend fun getMarvel(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<MarvelResponse>
}