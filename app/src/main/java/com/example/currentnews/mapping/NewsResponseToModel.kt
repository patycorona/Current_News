package com.example.currentnews.mapping

import com.example.currentnews.models.news.ManyNewsResponse
import com.example.currentnews.models.news.NewsModel

internal fun ManyNewsResponse.toModel(): MutableList<NewsModel> {
    val newsList: MutableList<NewsModel> = mutableListOf()

    listNews.map { NR ->
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
