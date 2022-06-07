package com.example.cleanarchitecturedemo.data.repository

import com.example.cleanarchitecturedemo.data.model.MealsDTO
import com.example.cleanarchitecturedemo.data.remote.MealAPIInterface
import com.example.cleanarchitecturedemo.domain.repository.MealSearchRepository

/**
 * Created by Ajeet Singh on 05/06/22.
 */

/**
 * Implementation for Meals Search Repo(Template)
 * @param mealSearchAPI an instance of MealAPIInterface that will be injected by Hilt
 */
class MealSearchRepositoryImpl(private val mealSearchAPI: MealAPIInterface) : MealSearchRepository {
    override suspend fun getMealList(searchQuery: String): MealsDTO {
        return mealSearchAPI.getMealList(searchQuery)
    }
}