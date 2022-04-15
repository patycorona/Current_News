package com.example.currentnews.platform.module

import com.example.currentnews.api.CoreHomeApi
import com.example.currentnews.repository.AddNewsRepository
import com.example.currentnews.repository.UserRegisterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
class RepositoryModule {
    @Provides
    fun userRegisterRepositoryPrivider(apiService: CoreHomeApi):
            AddNewsRepository = AddNewsRepository(apiService)
}