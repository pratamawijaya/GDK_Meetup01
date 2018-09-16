package com.pratamawijaya.demomvp.ui.home

import com.pratamawijaya.demomvp.domain.Article

interface MainListener {
    fun onItemClick(article: Article)
}

class MainAdapter(val listener: MainListener) {

}