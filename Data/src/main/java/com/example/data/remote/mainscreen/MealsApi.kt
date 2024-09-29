package com.example.data.remote.mainscreen

import com.example.domain.entity.mainscreen.MealModelItems
import retrofit2.http.GET

interface MealsApi {
    @GET("api/json/v1/1/categories.php")
    suspend fun getMeals(): MealModelItems

    //https://www.themealdb.com/

}