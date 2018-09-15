package com.pratamawijaya.demomvp.data.model.response

import com.pratamawijaya.demomvp.data.model.ArticleModel

data class ArticleResponse(
        val status:String,
        val result:Int,
        val articles:List<ArticleModel>
)