package com.example.cleanarchitecturedemo.data.repository

import com.example.cleanarchitecturedemo.data.model.MealDTO
import com.example.cleanarchitecturedemo.data.model.MealsDTO
import com.example.cleanarchitecturedemo.data.remote.MealSearchImpl
import com.example.cleanarchitecturedemo.domain.repository.MealDetailsRepository

/**
 * Created by Ajeet Singh on 05/06/22.
 */
class MealDetailsRepositoryImpl(val searchAPI: MealSearchImpl) : MealDetailsRepository {
    override suspend fun getMealDetails(mealId: String): MealsDTO {
        return searchAPI.getMealDetails(mealId)
    }
}