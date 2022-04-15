package com.example.currentnews.models.news

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class NewsModel(
    var id: Int,
    var title: String = "",
    var news: String = "",
    var image: String = ""
) : Parcelable
