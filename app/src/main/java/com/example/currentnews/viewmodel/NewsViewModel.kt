package com.example.currentnews.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currentnews.models.user.AccessResultModel
import com.example.currentnews.repository.AddNewsRepository
import com.example.currentnews.repository.UserAccessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    var userAccessRepository: UserAccessRepository,
    var addNewsRepository: AddNewsRepository
) : ViewModel() {

    // ayuda a liberar los recursos cuando utilizamos programacion reactiva
    private val compositeDisposable = CompositeDisposable()

    val userAccessResult: MutableLiveData<AccessResultModel> by lazy {
        MutableLiveData<AccessResultModel>()
    }

    val addNewsResult: MutableLiveData<AccessResultModel> by lazy {
        MutableLiveData<AccessResultModel>()
    }

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

    fun addNewsValidation(title: String, news: String, image: String) {

        compositeDisposable += addNewsRepository.addNews(
            title = title, news = news, image = image
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

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
