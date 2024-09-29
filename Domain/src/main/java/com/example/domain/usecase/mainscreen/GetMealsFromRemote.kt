package com.example.domain.usecase.mainscreen

import com.example.domain.repo.mainscreen.MainScreenRepo

class GetMealsFromRemote(private val mainScreenRepo: MainScreenRepo)  {
    suspend operator fun invoke() = mainScreenRepo.getMealsFromRemote()



}