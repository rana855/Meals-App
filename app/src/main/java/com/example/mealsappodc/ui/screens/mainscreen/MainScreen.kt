package com.example.mealsappodc.ui.screens.mainscreen

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel

import androidx.navigation.NavController
import com.example.mealsappodc.Screen
import com.google.gson.Gson

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreen(navController: NavController? = null, viewmodel: MainViewModel = hiltViewModel()) {

    val meals by viewmodel.meals.collectAsState()

    Box(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 30.dp)){
        LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 10.dp)) {
            items(meals.categories){
                MealItem(title = it.strCategory ?: "" , imageUrl = it.strCategoryThumb ?: "")
                {
                    navController?.navigate(Screen.MealDetailsScreen.route)
                }
            }
        }
    }


}

