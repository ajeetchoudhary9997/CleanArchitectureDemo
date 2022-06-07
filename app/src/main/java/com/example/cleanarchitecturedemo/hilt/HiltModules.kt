package com.example.cleanarchitecturedemo.hilt

import com.example.cleanarchitecturedemo.data.repository.MealDetailsRepositoryImpl
import com.example.cleanarchitecturedemo.data.remote.MealSearchImpl
import com.example.cleanarchitecturedemo.data.repository.MealSearchRepositoryImpl
import com.example.cleanarchitecturedemo.domain.repository.MealDetailsRepository
import com.example.cleanarchitecturedemo.domain.repository.MealSearchRepository
import com.example.cleanarchitecturedemo.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Ajeet Singh on 05/06/22.
 */
@Module
@InstallIn(SingletonComponent::class)
object HiltModules {
    @Provides
    @Singleton
    fun provideMealSearchAPI(): MealSearchImpl {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MealSearchImpl::class.java)
    }

    @Provides
    fun provideMealSearchRepo(mealSearchAPI: MealSearchImpl): MealSearchRepository {
        return MealSearchRepositoryImpl(mealSearchAPI)
    }


    @Provides
    fun provideMealDetailsRepo(searchMealSearchAPI: MealSearchImpl): MealDetailsRepository {
        return MealDetailsRepositoryImpl(searchMealSearchAPI)
    }


}