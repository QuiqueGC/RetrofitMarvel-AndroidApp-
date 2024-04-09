package com.example.retrofitmarvel.ui.list_fragment

import com.example.retrofitmarvel.data.domain.model.hero.HeroListModel
import com.example.retrofitmarvel.data.domain.model.hero.HeroModel

sealed class ListFragmentUiState {
    object Loading : ListFragmentUiState()
    data class Success(val heroList: MutableList<HeroModel>) : ListFragmentUiState()
    data class Error(val msg: String) : ListFragmentUiState()
}