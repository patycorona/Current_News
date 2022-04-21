package com.example.currentnews.platform.module

import com.example.currentnews.api.CoreHomeApi
import com.example.currentnews.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class RegisterNewsModule {
    @Provides
    fun registerNewsRepositoryProvider(apiService: CoreHomeApi):
        NewsRepository = NewsRepository(apiService)
}
