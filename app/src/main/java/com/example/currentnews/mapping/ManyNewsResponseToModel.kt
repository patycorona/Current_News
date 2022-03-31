package com.example.currentnews.mapping

import com.example.currentnews.models.ManyNewsResponse
import com.example.currentnews.models.News

internal fun ManyNewsResponse.toModel(): MutableList<News> {
    val recipeBookList: MutableList<News> = mutableListOf()

    newsR.map { NR ->
        recipeBookList.add(
            News(
                idRecipebook = NR.idRecipebook,
                nameRecipebook = NR.nameRecipebook,
                productPhoto = NR.productPhoto,
                recipeBook = NR.recipeBook,
                created_at = NR.created_at,
                author = NR.author
            )
        )
    }

    return recipeBookList

}