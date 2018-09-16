package com.pratamawijaya.demomvp.ui.home.item

import android.support.v7.widget.LinearLayoutManager
import com.pratamawijaya.demomvp.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_horizontal.view.rvHorizontal

class ArticleHorizontalItem(val horizontalAdapter: GroupAdapter<ViewHolder>) : Item() {

    override fun bind(viewHolder: com.xwray.groupie.kotlinandroidextensions.ViewHolder, position: Int) {
        viewHolder.itemView.rvHorizontal.apply {
            layoutManager = LinearLayoutManager(viewHolder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
            adapter = horizontalAdapter
        }

    }

    override fun getLayout(): Int = R.layout.item_horizontal

}