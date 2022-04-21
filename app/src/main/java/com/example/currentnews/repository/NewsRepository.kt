package com.example.currentnews.repository

import com.example.currentnews.api.CoreHomeApi
import com.example.currentnews.mapping.toModel
import com.example.currentnews.models.news.NewsModel
import io.reactivex.Single
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {

    fun getAllNews(): Single<MutableList<NewsModel>> {
        return apiService.getNews()
            .map { newsR ->
                newsR.toModel()
            }
    }
}
