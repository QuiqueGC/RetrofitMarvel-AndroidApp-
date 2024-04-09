package com.example.retrofitmarvel.data.domain.model.hero

import com.example.retrofitmarvel.data.domain.model.BaseModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroListModel(
    val results: List<HeroModel> = arrayListOf()
) : BaseModel()