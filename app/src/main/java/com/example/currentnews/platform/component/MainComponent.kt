package com.example.currentnews.platform.component

import com.example.currentnews.platform.module.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        UserRegisterModule::class,
        RepositoryModule::class,
        RegisterNewsModule::class,
        RetrofitModule::class
    ]
)
interface MainComponent
