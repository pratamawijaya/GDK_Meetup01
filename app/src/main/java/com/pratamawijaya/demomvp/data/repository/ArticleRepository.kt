package com.pratamawijaya.demomvp.data.repository

import com.pratamawijaya.demomvp.domain.Article
import io.reactivex.Single

interface ArticleRepository {
    fun getArticles() : Single<List<Article>>
}