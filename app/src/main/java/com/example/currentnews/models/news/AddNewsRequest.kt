package com.example.currentnews.models.news

import com.google.gson.annotations.SerializedName

data class AddNewsRequest(
    @SerializedName("title") val title: String = "",
    @SerializedName("news") val news: String = "",
    @SerializedName("image") val image: String = ""

)
