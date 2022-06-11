package com.example.cleanarchitecturedemo.presentation.meal_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturedemo.domain.use_case.GetMealDetailUseCase
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
class MealDetailsViewModel @Inject constructor(private val mealDetailsUseCase: GetMealDetailUseCase) :
    ViewModel() {


    private val _mealDetails = MutableStateFlow<MealDetailsUiState>(MealDetailsUiState())
    val mealDetails: StateFlow<MealDetailsUiState> = _mealDetails

    /**
     * Observe the flow and update state for meal details
     */
    fun getMealDetails(id: String) {
        mealDetailsUseCase(id).onEach {
            when (it) {
                is Resource.Loading -> {
                    _mealDetails.value = MealDetailsUiState(isLoading = true)
                }
                is Resource.Error -> {
                    _mealDetails.value = MealDetailsUiState(error = it.message ?: "")
                }
                is Resource.Success -> {
                    if (it.data?.isEmpty() == true)
                        _mealDetails.value = MealDetailsUiState(error = it.message ?: "")
                    else
                        _mealDetails.value = MealDetailsUiState(data = it.data?.get(0))
                }
            }
        }.launchIn(viewModelScope)
    }


}