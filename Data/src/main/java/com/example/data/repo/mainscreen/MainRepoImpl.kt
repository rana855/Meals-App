package com.example.data.repo.mainscreen

import com.example.data.remote.mainscreen.MealsApi
import com.example.domain.entity.mainscreen.MealModelItems
import com.example.domain.repo.mainscreen.MainScreenRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class MainRepoImpl (private val mealsApi: MealsApi) : MainScreenRepo {
    override suspend fun getMealsFromRemote(): MealModelItems = withContext(Dispatchers.IO) {
        return@withContext mealsApi.getMeals()
    }
}