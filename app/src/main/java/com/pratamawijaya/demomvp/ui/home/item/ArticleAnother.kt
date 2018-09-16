package com.pratamawijaya.demomvp.ui.home.item

import com.pratamawijaya.demomvp.R
import com.pratamawijaya.demomvp.domain.Article
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_article_another.view.tvTitle

class ArticleAnother(val article: Article) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.tvTitle.text = article.title
    }

    override fun getLayout(): Int = R.layout.item_article_another

}