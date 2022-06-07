package com.example.cleanarchitecturedemo.domain.repository

import com.example.cleanarchitecturedemo.data.model.MealsDTO

/**
 * Created by Ajeet Singh on 05/06/22.
 */
interface MealSearchRepository {
    suspend fun getMealList(searchQuery: String): MealsDTO
}