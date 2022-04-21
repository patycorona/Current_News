package com.example.currentnews.models.news

import com.google.gson.annotations.SerializedName

class ManyNewsResponse {
    @SerializedName("list_news")
    val listNews: MutableList<NewsRequest> = mutableListOf()
}
