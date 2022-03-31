package com.example.currentnews.api

import com.example.currentnews.models.ManyNewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface CoreHomeApi {

    @GET("/news")
    @Headers("Content-Type: application/json ")
    fun getRecipebook(): Single<ManyNewsResponse>

}