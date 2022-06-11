package com.example.cleanarchitecturedemo.hilt

import com.example.cleanarchitecturedemo.data.remote.MealAPIInterface
import com.example.cleanarchitecturedemo.data.repository.MealDetailsRepositoryImpl
import com.example.cleanarchitecturedemo.data.repository.MealSearchRepositoryImpl
import com.example.cleanarchitecturedemo.domain.repository.MealDetailsRepository
import com.example.cleanarchitecturedemo.domain.repository.MealSearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Ajeet Singh on 09/06/22.
 */


/**
 * provide the dependency for the interfaces
 * Using SingletonComponent because we need to inject these dependency in the top of the hierarchy
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    /**
     * Will provide MealSearchRepository dependency where required
     * this function dependent of MealSearchRepositoryImpl that will be injected via constructor injection by Hilt
     */
    @Binds
    abstract fun bindMealSearchRepository(mealSearchAPI: MealSearchRepositoryImpl): MealSearchRepository

    /**
     * Will provide MealDetailsRepository dependency where required
     * this function dependent of MealDetailsRepositoryImpl that will be injected via constructor injection by Hilt
     */
    @Binds
    abstract fun bindMealDetailsRepository(mealSearchAPI: MealDetailsRepositoryImpl): MealDetailsRepository
}