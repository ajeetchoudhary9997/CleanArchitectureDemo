package com.example.cleanarchitecturedemo.domain.use_case

import com.example.cleanarchitecturedemo.data.model.mapper.toDomainMeal
import com.example.cleanarchitecturedemo.domain.model.Meal
import com.example.cleanarchitecturedemo.domain.repository.MealSearchRepository
import com.example.cleanarchitecturedemo.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Ajeet Singh on 06/06/22.
 */

/**
 * This class will contain the meal search result use cases
 */
class GetMealSearchListUseCase @Inject constructor(private val repository: MealSearchRepository) {
    /**
     * Invoke operator that will return a flow, that emits the API response
     */
    operator fun invoke(searchQuery: String): Flow<Resource<List<Meal>>> = flow {
        try {
            emit(Resource.Loading())
            val data = withContext(Dispatchers.IO) { repository.getMealList(searchQuery) }
            val domainData = data.meals.map { it.toDomainMeal() }
            emit(Resource.Success(data = domainData))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {

        }
    }
}