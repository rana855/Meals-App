package com.example.mealsappodc.di

import com.example.domain.repo.mainscreen.MainScreenRepo
import com.example.domain.usecase.mainscreen.GetMealsFromRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    //Main
    @Provides
    fun provideGetMealsFromRemoteUseCase(mainRepo: MainScreenRepo): GetMealsFromRemote {
        return GetMealsFromRemote(mainRepo)
    }
}