package com.example.retrofitmarvel.data.domain.usecase

import com.example.retrofitmarvel.data.domain.model.hero.MarvelModel
import com.example.retrofitmarvel.data.domain.repository.DataProvider
import kotlinx.coroutines.flow.Flow

class GetMarvelUseCase(private val dataProvider: DataProvider) {
    operator fun invoke(limit: Int, offset: Int): Flow<MarvelModel> {
        return dataProvider.getListHeroes(limit, offset)
    }
}