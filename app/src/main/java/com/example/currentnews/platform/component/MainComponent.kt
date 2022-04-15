package com.example.currentnews.platform.component

import com.example.currentnews.platform.module.RegisterNewsModule
import com.example.currentnews.platform.module.RepositoryModule
import com.example.currentnews.platform.module.RetrofitModule
import com.example.currentnews.platform.module.UserRegisterModule
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
