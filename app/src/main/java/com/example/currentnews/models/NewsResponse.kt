package com.example.currentnews.models

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("recipe_id") val idRecipebook: String = "",
    @SerializedName("author") val author: String = "",
    @SerializedName("title") val nameRecipebook: String = "",
    @SerializedName("detail") val recipeBook: String = "",
    @SerializedName("image_url") val productPhoto: String = "",
    @SerializedName("created_at") val created_at : String = ""
)
