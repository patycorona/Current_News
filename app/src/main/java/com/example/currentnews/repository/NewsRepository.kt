package com.example.currentnews.repository

import com.example.currentnews.api.CoreHomeApi
import com.example.currentnews.mapping.toModel
import com.example.currentnews.models.news.AddNewsRequest
import com.example.currentnews.models.news.NewsModel
import com.example.currentnews.models.user.AccessResultModel
import io.reactivex.Single
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {
    fun addNews(title: String, news: String, image: String): Single<AccessResultModel> {
        return apiService.addNewNews(
            addNewsRequest = AddNewsRequest(
                title = title,
                news = news,
                image = image
            )
        )
            .map { userAccessResponse ->
                userAccessResponse.toModel()
            }
    }

    fun getAllNews(): Single<MutableList<NewsModel>> {
        return apiService.getNews()
            .map { newsR ->
                newsR.toModel()
            }
    }
}
