package com.example.cleanarchitecturedemo.presentation.meal_search

import com.example.cleanarchitecturedemo.domain.model.Meal

/**
 * Created by Ajeet Singh on 06/06/22.
 */
class MealSearchState(
    val data: List<Meal>? = null,
    val error: String = "",
    val isLoading: Boolean = false
) {
}