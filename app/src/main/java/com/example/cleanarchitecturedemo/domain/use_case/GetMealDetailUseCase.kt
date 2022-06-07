package com.example.cleanarchitecturedemo.domain.use_case

import com.example.cleanarchitecturedemo.data.model.toDomainMealDetails
import com.example.cleanarchitecturedemo.domain.model.MealDetails
import com.example.cleanarchitecturedemo.domain.repository.MealDetailsRepository
import com.example.cleanarchitecturedemo.domain.repository.MealSearchRepository
import com.example.cleanarchitecturedemo.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Ajeet Singh on 06/06/22.
 */
class GetMealDetailUseCase @Inject constructor(private val repository: MealDetailsRepository) {

    operator fun invoke(mealId: String): Flow<Resource<List<MealDetails>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getMealDetails(mealId)
            val domainData =
                if (!data.meals.isNullOrEmpty()) data.meals.map { it -> it.toDomainMealDetails() } else emptyList()
            emit(Resource.Success(data = domainData))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {

        }
    }
}