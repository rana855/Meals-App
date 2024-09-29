package com.example.mealsappodc

sealed class Screen(val route: String) {
    object MainScreen : Screen("mainScreen")
    object MealDetailsScreen : Screen("mealDetailsScreen")
}
