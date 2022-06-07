package com.example.cleanarchitecturedemo.data.repository

import com.example.cleanarchitecturedemo.data.model.MealsDTO
import com.example.cleanarchitecturedemo.data.remote.MealAPIInterface
import com.example.cleanarchitecturedemo.domain.repository.MealDetailsRepository

/**
 * Created by Ajeet Singh on 05/06/22.
 */

/**
 * Implementation for Meals Details Repo(Template)
 * @param mealSearchAPI an instance of MealAPIInterface that will be injected by Hilt
 */
class MealDetailsRepositoryImpl(private val mealSearchAPI: MealAPIInterface) : MealDetailsRepository {
    override suspend fun getMealDetails(mealId: String): MealsDTO {
        return mealSearchAPI.getMealDetails(mealId)
    }
}