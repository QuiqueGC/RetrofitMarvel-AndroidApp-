package com.example.retrofitmarvel.data.domain.repository.remote

import com.example.retrofitmarvel.data.domain.model.hero.MarvelModel
import com.example.retrofitmarvel.data.domain.repository.DataSource
import com.example.retrofitmarvel.data.domain.repository.remote.mapper.hero.MarvelMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource(private val remoteApiService: RemoteApiService) : DataSource {
    companion object {
        var INSTANCE: RemoteDataSource? = null

        @Synchronized
        fun getInstance(remoteApiService: RemoteApiService): RemoteDataSource {
            if (INSTANCE == null) {
                INSTANCE = RemoteDataSource(remoteApiService)
            }
            return INSTANCE!!
        }
    }

    override fun getListHeroes(limit: Int, offset: Int): Flow<MarvelModel> = flow {
        emit(
            MarvelMapper().fromResponse(
                remoteApiService.getMarvel(limit, offset).body()!!
            )
        )
    }
}