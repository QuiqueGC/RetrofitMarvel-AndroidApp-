package com.example.retrofitmarvel.data.domain.repository.remote.response

import com.google.gson.annotations.SerializedName

data class HeroListResponse(
    @SerializedName("offset")
    val offset: Int?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("results")
    val results: List<HeroResponse>?

)