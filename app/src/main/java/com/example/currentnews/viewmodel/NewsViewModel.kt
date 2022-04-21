package com.example.currentnews.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currentnews.models.news.NewsResult
import com.example.currentnews.models.user.AccessResultModel
import com.example.currentnews.repository.AddNewsRepository
import com.example.currentnews.repository.NewsRepository
import com.example.currentnews.repository.UserAccessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    var userAccessRepository: UserAccessRepository,
    var newsRepository: NewsRepository,
    var addNewsRepository: AddNewsRepository
) : ViewModel() {

    // ayuda a liberar los recursos cuando utilizamos programacion reactiva
    private val compositeDisposable = CompositeDisposable()

    val userAccessResult: MutableLiveData<AccessResultModel> by lazy {
        MutableLiveData<AccessResultModel>()
    }

    val listNewsRs: MutableLiveData<NewsResult> by lazy {
        MutableLiveData<NewsResult>()
    }

    val addNewsResult: MutableLiveData<AccessResultModel> by lazy {
        MutableLiveData<AccessResultModel>()
    }

    // Login
    fun userValidation(email: String, pwd: String) {

        compositeDisposable += userAccessRepository.userAccess(
            user = email, password = pwd
        )
            .subscribeOn(Schedulers.io())
            .subscribe({ accessResultModel ->
                userAccessResult.postValue(accessResultModel)
            }, {
                userAccessResult.postValue(
                    AccessResultModel(
                        code = "-1",
                        message = "an exception occurred"
                    )
                )
            })
    }

    // add News
    fun addNewsValidation(title: String, news: String, image: String) {

        compositeDisposable += addNewsRepository.AddNewNews(
            title = title, news = news, image = image
        )
            .subscribeOn(Schedulers.io())
            .subscribe({ accessResultModel ->
                addNewsResult.postValue(accessResultModel)
            }, {
                userAccessResult.postValue(
                    AccessResultModel(
                        code = "-1",
                        message = "an exception occurred"
                    )
                )
            })
    }

    fun getNews() {

        compositeDisposable += newsRepository.getAllNews()
            .subscribeOn(Schedulers.io())
            .subscribe({ listNewsR ->
                listNewsRs.postValue(
                    NewsResult(
                        sussess = true,
                        list = listNewsR
                    )
                )
            }, {
                listNewsRs.postValue(
                    NewsResult(
                        sussess = false
                    )
                )
            })
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
