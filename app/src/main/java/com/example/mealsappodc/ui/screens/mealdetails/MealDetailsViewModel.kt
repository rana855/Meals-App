package com.example.mealsappodc.ui.screens.mealdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _mealName = MutableStateFlow("")
    val mealName = _mealName.asStateFlow()


    init {
        val data = savedStateHandle.get<String>("mealName")
        data?.let {
            _mealName.value = data
        }
    }
}