package com.pratamawijaya.demomvp.domain

import java.util.*

data class Article(
        val title: String,
        val desc: String,
        val image: String,
        val author: String,
        val date: Date
)