package com.example.retrofitmarvel.injection

import com.example.retrofitmarvel.data.domain.repository.DataProvider
import com.example.retrofitmarvel.data.domain.repository.remote.RemoteApiService
import com.example.retrofitmarvel.data.domain.repository.remote.RemoteDataSource
import com.example.retrofitmarvel.data.domain.repository.remote.RetrofitClient

class InjectionSingleton {
    companion object {
        private fun provideApiServices(): RemoteApiService {
            return RetrofitClient.getInstance().getApiServices()
        }

        fun provideDataSource(): DataProvider {
            return DataProvider.getInstance(RemoteDataSource.getInstance(provideApiServices()))
        }

    }
}