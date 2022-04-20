package com.example.currentnews.models.news

import com.google.gson.annotations.SerializedName

data class NewsRequest(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String = "",
    @SerializedName("news") val news: String = "",
    @SerializedName("url_image") val image: String = ""
)
