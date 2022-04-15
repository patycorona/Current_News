package com.example.currentnews.views.login

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class UserAccessModel(
    var email: String = "",
    var password: String = ""
): Parcelable {}