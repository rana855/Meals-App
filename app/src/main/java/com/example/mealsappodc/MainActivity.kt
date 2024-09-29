package com.example.mealsappodc

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealsappodc.ui.screens.mainscreen.MainScreen
import com.example.mealsappodc.ui.screens.mealdetails.MealDetailsScreen
import com.example.mealsappodc.ui.theme.MealsAppODCTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealsAppODCTheme {
                MealsAppCompose()
            }
        }
    }
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MealsAppCompose() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) { MainScreen(navController) }
        composable(
            "${Screen.MealDetailsScreen.route}/{mealName}",
            arguments = listOf(navArgument("mealName") { type = NavType.StringType })
        ) { backStackEntry ->
            val mealName = backStackEntry.arguments?.getString("mealName")
            MealDetailsScreen()
        }
    }
}


