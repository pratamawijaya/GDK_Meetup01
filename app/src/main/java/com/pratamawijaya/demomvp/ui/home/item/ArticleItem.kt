package com.pratamawijaya.demomvp.ui.home.item

import com.pratamawijaya.demomvp.R
import com.pratamawijaya.demomvp.domain.Article
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_article.view.tvDesc
import kotlinx.android.synthetic.main.item_article.view.tvTitle

class ArticleItem(val article: Article) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.tvTitle.text = article.title
        viewHolder.itemView.tvDesc.text = article.desc
    }

    override fun getLayout(): Int = R.layout.item_article
}