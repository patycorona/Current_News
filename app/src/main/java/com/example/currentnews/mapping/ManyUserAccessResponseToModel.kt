package com.example.currentnews.mapping

import com.example.currentnews.models.user.AccessResultModel
import com.example.currentnews.models.user.UserAccessResponse

internal fun UserAccessResponse.toModel() =
    AccessResultModel(code = code, message = message)