package com.example.cleanarchitecturedemo.domain.repository

import com.example.cleanarchitecturedemo.data.model.MealsDTO

/**
 * Created by Ajeet Singh on 05/06/22.
 */

/**
 * Template class for Meals Details Repo
 */
interface MealDetailsRepository {
    suspend fun getMealDetails(mealId: String): MealsDTO
}