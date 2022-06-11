package com.example.cleanarchitecturedemo.presentation.meal_search

import com.example.cleanarchitecturedemo.domain.model.Meal

/**
 * Created by Ajeet Singh on 06/06/22.
 */

/**
 * Meal Search State that will be exposed to the UI that have multiple state, denoted by  its params
 * @param isLoading will be true if API loading data
 * @param data will provide data once the API returns it
 * @param error if any unexpected things happen during API call, it will return error
 */
class MealSearchUiState(
    val data: List<Meal>? = null,
    val error: String = "",
    val isLoading: Boolean = false
) {
}