package com.example.retrofitmarvel.ui.list_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitmarvel.data.domain.model.hero.HeroModel
import com.example.retrofitmarvel.data.domain.usecase.GetMarvelUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ListFragmentViewModel(private val getMarvelUseCase: GetMarvelUseCase) : ViewModel() {

    /*private val _heroes = MutableStateFlow<MutableList<HeroModel>>(mutableListOf())
    val heroes: StateFlow<MutableList<HeroModel>> = _heroes*/

    private val _uiState = MutableStateFlow<ListFragmentUiState>(ListFragmentUiState.Loading)
    val uiState : StateFlow<ListFragmentUiState> = _uiState
    private val heroesList = mutableListOf<HeroModel>()
    private var page = 0
    private val pageSize = 10

    /*fun getHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            getMarvelUseCase(pageSize, page * pageSize).collect {
                heroesList.addAll(it.heroListModel.results)
                _heroes.value = heroesList
            }
        }
        page++
    }*/

    fun getPageOfHeroes(){
        viewModelScope.launch(Dispatchers.IO) {
            getMarvelUseCase(pageSize, page * pageSize)
                .catch { ListFragmentUiState.Error(it.message.orEmpty()) }
                .collect {
                heroesList.addAll(it.heroListModel.results)
                _uiState.value = ListFragmentUiState.Success(heroesList)
            }
        }
        page++
    }
}