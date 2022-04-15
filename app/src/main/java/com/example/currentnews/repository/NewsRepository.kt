package com.example.currentnews.repository

import com.example.currentnews.api.CoreHomeApi
import com.example.currentnews.mapping.toModel
import com.example.currentnews.models.news.NewsModel
import com.example.currentnews.models.news.NewsRequest
import com.example.currentnews.models.user.AccessResultModel
import io.reactivex.Single
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {
    fun addNews(id: Int, title: String, news: String, image: String): Single<AccessResultModel> {
        return apiService.addNewNews(
            addNewsRequest = NewsRequest(
                id = id,
                title = title,
                news = news,
                image = image
            )
        )
            .map { userAccessResponse ->
                userAccessResponse.toModel()
            }
    }

    fun getNews(): Single<MutableList<NewsModel>> {
        return apiService.getNews()
            .map { newsR ->
                newsR.toModel()
            }
    }
}
