package com.pratamawijaya.demomvp.ui.home

import android.view.View
import com.pratamawijaya.demomvp.domain.Article

interface MainListener {
    fun onItemClick(article: Article)
}

class MainAdapter(val listener: MainListener) {

    init {

        val btn: View? = null

        btn?.setOnClickListener {
            listener.onItemClick(Article(title = "", desc = "", author = "", image = ""))
        }
    }

}