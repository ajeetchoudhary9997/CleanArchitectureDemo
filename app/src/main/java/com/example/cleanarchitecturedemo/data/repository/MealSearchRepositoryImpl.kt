package com.example.cleanarchitecturedemo.data.repository

import com.example.cleanarchitecturedemo.data.model.MealsDTO
import com.example.cleanarchitecturedemo.data.remote.MealSearchImpl
import com.example.cleanarchitecturedemo.domain.repository.MealSearchRepository

/**
 * Created by Ajeet Singh on 05/06/22.
 */
class MealSearchRepositoryImpl(val mealSearchAPI: MealSearchImpl) : MealSearchRepository {
    override suspend fun getMealList(searchQuery: String): MealsDTO {
        return mealSearchAPI.getMealList(searchQuery)
    }
}