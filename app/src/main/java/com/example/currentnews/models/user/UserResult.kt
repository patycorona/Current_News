package com.example.currentnews.models.user

import com.google.gson.annotations.SerializedName

data class UserResult(
    @SerializedName( "code") val code:String = "",
    @SerializedName( "message") val message:String = ""
)
