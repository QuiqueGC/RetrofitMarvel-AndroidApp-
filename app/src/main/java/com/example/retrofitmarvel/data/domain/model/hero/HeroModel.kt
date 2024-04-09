package com.example.retrofitmarvel.data.domain.model.hero

import com.example.retrofitmarvel.data.domain.model.BaseModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroModel(
    val id: Int = -1,
    val name: String = "",
    val description: String = "No hay descripción disponible para este personaje.",
    val smallThumbnailPath: String = "",
    val largeThumbnailPath: String = ""
) : BaseModel()