package com.example.retrofitmarvel.data.domain.repository.remote.response

import com.google.gson.annotations.SerializedName

data class HeroResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailResponse
)
