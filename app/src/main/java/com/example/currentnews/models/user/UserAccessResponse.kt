package com.example.currentnews.models.user

import com.google.gson.annotations.SerializedName

data class UserAccessResponse(
    @SerializedName( "code") val code:String = "",
    @SerializedName( "message") val message:String = "",
    @SerializedName( "user") val user: UserModel = UserModel(),
)