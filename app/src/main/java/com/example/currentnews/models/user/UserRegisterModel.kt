package com.example.currentnews.models.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class UserRegisterModel (

    var email:String = "",
    var password:String = "",
    var name:String = "",
    var lastName:String = ""

): Parcelable {}