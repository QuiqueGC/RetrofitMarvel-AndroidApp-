package com.example.retrofitmarvel.data.domain.repository.remote.response

import com.google.gson.annotations.SerializedName

data class ThumbnailResponse(
    @SerializedName("path")
    val path: String?,
    @SerializedName("extension")
    val extension: String?,
) {
}