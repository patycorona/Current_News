package com.example.currentnews.repository

import com.example.currentnews.api.CoreHomeApi
import com.example.currentnews.mapping.toModel
import com.example.currentnews.models.user.AccessResultModel
import com.example.currentnews.models.user.UserRegisterRequest
import io.reactivex.Single
import javax.inject.Inject

class UserRegisterRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {
    fun userRegister(name: String, lastName: String, email: String, password: String): Single<AccessResultModel> {
        return apiService.userRegister(
            userRegisterRequest = UserRegisterRequest(
                name = name,
                lastName = lastName,
                email = email,
                password = password
            )
        )
            .map { userAccessResponse ->
                userAccessResponse.toModel()
            }
    }
}
