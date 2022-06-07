package com.example.cleanarchitecturedemo.domain.model
/**
 * Created by Ajeet Singh on 05/06/22.
 */

/**
 * Meal Actual model that will be used by the presenter layer,
 * this model will contain only relatable data for meal
 */
data class Meal(
    val mealId: String,
    val name: String,
    val image: String
)
