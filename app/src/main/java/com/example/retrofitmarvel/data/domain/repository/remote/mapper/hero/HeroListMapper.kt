package com.example.retrofitmarvel.data.domain.repository.remote.mapper.hero

import com.example.retrofitmarvel.data.domain.model.hero.HeroListModel
import com.example.retrofitmarvel.data.domain.model.hero.HeroModel
import com.example.retrofitmarvel.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitmarvel.data.domain.repository.remote.response.HeroListResponse

class HeroListMapper : ResponseMapper<HeroListResponse, HeroListModel> {

    override fun fromResponse(response: HeroListResponse): HeroListModel {
        val resultModel = mutableListOf<HeroModel>()

        if (!response.results.isNullOrEmpty()) {
            val heroMapper = HeroMapper()
            response.results.forEach { heroInResultsResponse ->
                resultModel.add(heroMapper.fromResponse(heroInResultsResponse))
            }
        }

        return HeroListModel(resultModel)
    }
}