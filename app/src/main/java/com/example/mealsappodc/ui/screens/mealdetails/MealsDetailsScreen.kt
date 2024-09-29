package com.example.mealsappodc.ui.screens.mealdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MealDetailsScreen(viewModel: MealDetailsViewModel = hiltViewModel()){

    val meal by viewModel.mealName.collectAsState()

    Box(Modifier.fillMaxSize()) {
        Text(meal, modifier = Modifier.align(Alignment.Center), textAlign = TextAlign.Start)
    }
}