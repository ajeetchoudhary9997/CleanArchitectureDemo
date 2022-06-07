package com.example.cleanarchitecturedemo.presentation.meal_search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturedemo.domain.use_case.GetMealSearchListUseCase
import com.example.cleanarchitecturedemo.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Ajeet Singh on 06/06/22.
 */
@HiltViewModel
class MealSearchViewModel @Inject constructor(private val getMealSearchListUseCase: GetMealSearchListUseCase) :
    ViewModel() {
    private val _mealSearchList = MutableStateFlow<MealSearchState>(MealSearchState())
    val mealSearchState: StateFlow<MealSearchState>
        get() = _mealSearchList

    fun getSearchMeals(searchQuery: String) {
        getMealSearchListUseCase(searchQuery).onEach {
            when (it) {
                is Resource.Loading -> {
                    _mealSearchList.value = MealSearchState(isLoading = true)
                }
                is Resource.Success -> {
                    _mealSearchList.value = MealSearchState(data = it.data)
                }
                is Resource.Error -> {
                    _mealSearchList.value = MealSearchState(error = it.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }}