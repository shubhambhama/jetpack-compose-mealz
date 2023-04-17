package com.example.mealzapp.model

import com.example.mealzapp.model.api.MealsWebService
import com.example.mealzapp.model.response.MealResponse
import com.example.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    private var cachedMeal = listOf<MealResponse>()
    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cachedMeal = response.categories
        return response
    }

    fun getMeal(id: String): MealResponse? {
        return cachedMeal.firstOrNull {
            it.id == id
        }
    }

    companion object  {
        @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: MealsRepository().also {
                instance = it
            }
        }
    }
}