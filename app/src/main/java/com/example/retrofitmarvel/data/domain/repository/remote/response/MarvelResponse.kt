package com.example.retrofitmarvel.data.domain.repository.remote.response

import com.google.gson.annotations.SerializedName

data class MarvelResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("attributionText")
    val attributionText: String?,
    @SerializedName("data")
    val data: HeroListResponse?,
)