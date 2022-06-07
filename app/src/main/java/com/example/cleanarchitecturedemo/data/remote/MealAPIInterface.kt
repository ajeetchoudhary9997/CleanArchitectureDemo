package com.example.cleanarchitecturedemo.data.remote

import com.example.cleanarchitecturedemo.data.model.MealsDTO
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Ajeet Singh on 06/06/22.
 */

/**
 * This interface will contain all the API calls
 */
interface MealAPIInterface {
    @GET("/api/json/v1/1/search.php")
    suspend fun getMealList(@Query("s") searchQuery:String): MealsDTO

    @GET("/api/json/v1/1/lookup.php")
    suspend fun getMealDetails(@Query("i") mealId:String):MealsDTO
}