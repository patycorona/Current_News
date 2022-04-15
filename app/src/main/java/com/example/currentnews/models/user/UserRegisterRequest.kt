package com.example.currentnews.models.user

import com.google.gson.annotations.SerializedName

data class UserRegisterRequest(
    @SerializedName("name") val name: String = "",
    @SerializedName("last_name") val lastName: String = "",
    @SerializedName("email") val email: String = "",
    @SerializedName("password") val password: String = ""
)
