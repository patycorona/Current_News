package com.example.currentnews.models

import com.example.currentnews.models.news.NewsRequest
import com.example.currentnews.models.user.UserModel
import com.google.gson.annotations.SerializedName

class NewsResponse {
    @SerializedName("news") val newsR: MutableList<NewsRequest> = mutableListOf()
}
