package com.example.currentnews.platform.module

import com.example.currentnews.api.CoreHomeApi
import com.example.currentnews.repository.AddNewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class RegisterNewsModule {
    @Provides
    fun AddNewsRepositoryProvider(apiService: CoreHomeApi):
        AddNewsRepository = AddNewsRepository(apiService)
}
