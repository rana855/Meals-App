package com.example.domain.repo.mainscreen

import com.example.domain.entity.mainscreen.MealModelItems

interface MainScreenRepo {
    suspend fun getMealsFromRemote(): MealModelItems
}