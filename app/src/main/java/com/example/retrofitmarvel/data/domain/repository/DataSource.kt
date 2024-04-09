package com.example.retrofitmarvel.data.domain.repository

import com.example.retrofitmarvel.data.domain.model.hero.MarvelModel
import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun getListHeroes(limit: Int, offset: Int): Flow<MarvelModel>
}