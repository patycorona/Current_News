package com.example.currentnews.models

import com.example.currentnews.models.news.NewsRequest
import com.google.gson.annotations.SerializedName

class ManyNewsResponse {
    @SerializedName("news") val newsR: MutableList<NewsRequest> = mutableListOf()
}