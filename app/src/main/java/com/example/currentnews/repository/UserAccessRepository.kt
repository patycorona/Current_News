package com.example.currentnews.repository

import com.example.currentnews.api.CoreHomeApi
import com.example.currentnews.mapping.toModel
import com.example.currentnews.models.user.AccessResultModel
import com.example.currentnews.views.login.UserAccessRequest
import io.reactivex.Single
import javax.inject.Inject

class UserAccessRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {
    fun userAccess(user: String, password: String): Single<AccessResultModel> {
        return apiService.userAccess(
            userAccessRequest = UserAccessRequest(
                email = user,
                password = password
            )
        )
            .map { userAccessResponse ->
                userAccessResponse.toModel()
            }
    }
}
