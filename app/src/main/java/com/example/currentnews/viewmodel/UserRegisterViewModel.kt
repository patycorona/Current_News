package com.example.currentnews.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currentnews.models.user.AccessResultModel
import com.example.currentnews.repository.UserRegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class UserRegisterViewModel @Inject constructor
(var userRegisterRepository: UserRegisterRepository) : ViewModel() {

    // ayuda a liberar los recursos cuando utilizamos programacion reactiva
    private val compositeDisposable = CompositeDisposable()

    val userRegisterLD: MutableLiveData<AccessResultModel> by lazy {
        MutableLiveData<AccessResultModel>()
    }

    fun userRegister(name: String, lastName: String, email: String, password: String) {
        compositeDisposable += userRegisterRepository.userRegister(
            name = name, lastName = lastName, email = email,
            password = password
        )
            .subscribeOn(Schedulers.io())
            .subscribe({ userReg ->
                userRegisterLD.postValue(userReg)
            }, {
                userRegisterLD.postValue(
                    AccessResultModel(
                        code = "-1",
                        message = "an exception occurred, please try again"
                    )
                )
            })
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
