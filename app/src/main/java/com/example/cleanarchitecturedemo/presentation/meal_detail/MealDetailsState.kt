package com.example.cleanarchitecturedemo.presentation.meal_detail

import com.example.cleanarchitecturedemo.domain.model.MealDetails

/**
 * Created by Ajeet Singh on 06/06/22.
 */
data class MealDetailsState(
    val isLoading: Boolean = false,
    val data: MealDetails? = null,
    val error: String = ""
)
