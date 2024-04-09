package com.example.retrofitmarvel.data.domain.repository.remote.mapper.hero

import com.example.retrofitmarvel.data.domain.model.hero.HeroModel
import com.example.retrofitmarvel.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitmarvel.data.domain.repository.remote.response.HeroResponse

class HeroMapper : ResponseMapper<HeroResponse, HeroModel> {
    override fun fromResponse(response: HeroResponse): HeroModel {
        var description = response.description
        if (response.description.isNullOrBlank()) {
            description = "No hay descripción disponible para este personaje."
        }
        return HeroModel(
            response.id ?: -1,
            response.name ?: "",
            description!!,
            response.thumbnail.path + "/standard_medium." + response.thumbnail.extension,
            response.thumbnail.path + "/standard_fantastic." + response.thumbnail.extension
        )
    }
}