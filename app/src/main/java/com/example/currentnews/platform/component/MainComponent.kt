package com.example.currentnews.platform.component

import com.example.currentnews.platform.module.RetrofitModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        RetrofitModule::class
    ]
)
interface MainComponent{
}