package com.example.mealsappodc.ui.screens.mainscreen

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.mainscreen.MealModelItems
import com.example.domain.usecase.mainscreen.GetMealsFromRemote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainViewModel"
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class MainViewModel @Inject constructor(private val getMealsFromRemote: GetMealsFromRemote) : ViewModel() {

    private val _meals = MutableStateFlow(MealModelItems(emptyList()))
    val meals = _meals.asStateFlow()

    init {
        getMeals()
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getMeals(){
        viewModelScope.launch {
            try {
                val data = getMealsFromRemote()
                _meals.value = data
                Log.d(TAG, "getMeals: ${Thread.currentThread().name}")
                Log.d(TAG, "getMeals: ${data.categories[0].strCategory}")
            }catch (e : Exception){
                if (e is HttpException){
                    Log.d(TAG, "HttpException getMeals: ${e.message}")
                }else{
                    Log.d(TAG, "Exception getMeals: ${e.message}")
                }
            }
        }
    }


}