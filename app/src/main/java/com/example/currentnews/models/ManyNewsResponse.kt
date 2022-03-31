package com.example.currentnews.models

import com.google.gson.annotations.SerializedName

class ManyNewsResponse {
    @SerializedName("news") val newsR: MutableList<NewsResponse> = mutableListOf()
}