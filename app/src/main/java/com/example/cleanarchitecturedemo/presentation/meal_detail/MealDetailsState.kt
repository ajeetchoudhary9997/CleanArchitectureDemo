package com.example.cleanarchitecturedemo.presentation.meal_detail

import com.example.cleanarchitecturedemo.domain.model.MealDetails

/**
 * Created by Ajeet Singh on 06/06/22.
 */

/**
 * Meal Details State that will be exposed to the UI that have multiple state, denoted by  its params
 * @param isLoading will be true if API loading data
 * @param data will provide data once the API returns it
 * @param error if any unexpected things happen during API call, it will return error
 */
data class MealDetailsState(
    val isLoading: Boolean = false,
    val data: MealDetails? = null,
    val error: String = ""
)
