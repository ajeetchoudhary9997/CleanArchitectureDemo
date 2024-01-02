package com.example.cleanarchitecturedemo.hilt

import com.example.cleanarchitecturedemo.data.remote.MealAPIInterface
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
    /**
     * Will provide MealAPIInterface object where required
     */
    @Provides
    @Singleton
    fun provideMealSearchAPI(): MealAPIInterface {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MealAPIInterface::class.java)
    }

}