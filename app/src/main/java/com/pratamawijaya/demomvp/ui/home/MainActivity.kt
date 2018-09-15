package com.pratamawijaya.demomvp.ui.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.pratamawijaya.demomvp.R
import com.pratamawijaya.demomvp.data.repository.ArticleRepositoryImpl
import com.pratamawijaya.demomvp.data.repository.UserRepositoryImpl
import com.pratamawijaya.demomvp.domain.Article
import com.pratamawijaya.demomvp.domain.User

class MainActivity : AppCompatActivity(), MainView, MainListener {

    // declare presenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = UserRepositoryImpl()
        val articleRepo = ArticleRepositoryImpl()
        val adapter = MainAdapter(this)

        // inisiasi presenter
        presenter = MainPresenter(this, repo, articleRepo)

        presenter.getUser()
        presenter.getArticles()
    }

    override fun onItemClick(article: Article) {
        // do something with article
        // presenter.updateArticle(article)
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showUserData(user: User) {
        // do something to user
        Log.d("tag", "user ${user.nama}")
    }


}
