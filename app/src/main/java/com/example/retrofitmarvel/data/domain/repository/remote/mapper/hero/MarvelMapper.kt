package com.example.retrofitmarvel.data.domain.repository.remote.mapper.hero

import com.example.retrofitmarvel.data.domain.model.hero.HeroListModel
import com.example.retrofitmarvel.data.domain.model.hero.MarvelModel
import com.example.retrofitmarvel.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitmarvel.data.domain.repository.remote.response.MarvelResponse

class MarvelMapper : ResponseMapper<MarvelResponse, MarvelModel> {

    override fun fromResponse(response: MarvelResponse): MarvelModel {
        var heroList = HeroListModel()
        if (response.data != null) {
            val heroListMapper = HeroListMapper()
            heroList = heroListMapper.fromResponse(response.data)
        }
        return MarvelModel(heroList)
    }
}