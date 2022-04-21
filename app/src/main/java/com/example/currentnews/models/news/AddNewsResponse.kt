package com.example.currentnews.models.news

import com.google.gson.annotations.SerializedName

data class AddNewsResponse(
    @SerializedName("code") val code: String = "",
    @SerializedName("message") val message: String = ""
)
