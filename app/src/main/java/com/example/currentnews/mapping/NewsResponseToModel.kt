package com.example.currentnews.mapping

import com.example.currentnews.models.NewsResponse
import com.example.currentnews.models.news.NewsModel

internal fun NewsResponse.toModel(): MutableList<NewsModel> {
    val newsList: MutableList<NewsModel> = mutableListOf()

    newsR.map { NR ->
        newsList.add(
            NewsModel(
                id = NR.id,
                title = NR.title,
                news = NR.news,
                image = NR.image,
            )
        )
    }

    return newsList
}
