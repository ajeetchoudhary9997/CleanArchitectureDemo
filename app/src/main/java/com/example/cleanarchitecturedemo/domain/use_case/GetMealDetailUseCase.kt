package com.example.cleanarchitecturedemo.domain.use_case

import com.example.cleanarchitecturedemo.data.model.mapper.toDomainMealDetails
import com.example.cleanarchitecturedemo.domain.model.MealDetails
import com.example.cleanarchitecturedemo.domain.repository.MealDetailsRepository
import com.example.cleanarchitecturedemo.utils.Resource
import kotlinx.coroutines.Dispatchers
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
 * This class will contain the meal details use cases
 */
class GetMealDetailUseCase @Inject constructor(private val repository: MealDetailsRepository) {

    /**
     * Invoke operator that will return a flow, that emits the API response
     */
    operator fun invoke(mealId: String): Flow<Resource<List<MealDetails>>> = flow {
        try {
            emit(Resource.Loading())
            val data = withContext(Dispatchers.IO) { repository.getMealDetails(mealId) }
            val domainData =
                if (!data.meals.isNullOrEmpty()) data.meals.map { it.toDomainMealDetails() } else emptyList()
            emit(Resource.Success(data = domainData))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {

        }
    }
}