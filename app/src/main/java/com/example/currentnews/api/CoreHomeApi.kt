package com.example.currentnews.api

import com.example.currentnews.models.NewsResponse
import com.example.currentnews.models.news.AddNewsRequest
import com.example.currentnews.models.news.ManyNewsResponse
import com.example.currentnews.models.news.NewsRequest
import com.example.currentnews.models.user.AccessResultModel
import com.example.currentnews.models.user.UserAccessResponse
import com.example.currentnews.models.user.UserRegisterRequest
import com.example.currentnews.models.user.UserResult
import com.example.currentnews.views.login.UserAccessRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CoreHomeApi {

    @GET("/news")
    @Headers("Content-Type: application/json ")
    fun getNews(): Single<ManyNewsResponse>

    @POST("/news")
    @Headers("Content-Type: application/json ")
    fun addNewNews(@Body addNewsRequest: AddNewsRequest): Single<UserAccessResponse>

    @POST("/register_user_new")
    @Headers("Content-Type: application/json ")
    fun userRegister(@Body userRegisterRequest: UserRegisterRequest): Single<UserAccessResponse>

    @POST("/access_news")
    @Headers("Content-Type: application/json ")
    fun userAccess(@Body userAccessRequest: UserAccessRequest): Single<UserAccessResponse>
}
