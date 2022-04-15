package com.example.currentnews.views.login

import com.google.gson.annotations.SerializedName

data class UserAccessRequest(
    @SerializedName("email") val email: String = "",
    @SerializedName("password") val password: String = ""

)
