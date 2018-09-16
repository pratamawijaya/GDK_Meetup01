package com.pratamawijaya.demomvp.ui.home

import android.util.Log
import com.pratamawijaya.demomvp.data.PrefHelper
import com.pratamawijaya.demomvp.data.repository.ArticleRepository
import com.pratamawijaya.demomvp.data.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(val view: MainView,
                    val repo: UserRepository,
                    val repoArticle: ArticleRepository,
                    val prefHelper: PrefHelper) {

    fun getUser() {
        // ambil user dari db
        val user = repo.getUser()

        view.showUserData(user)
    }

    fun getArticles() {
        repoArticle.getArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    prefHelper.saveString(PrefHelper.PREF_TOKEN, "isi_token")
//                    view.showArticles(result)
                    result.map {
                        Log.d("tag", "dapet article -> ${it.title}")
                    }
                }, { error ->
                    Log.e("tag", "error ${error.localizedMessage}")
                })
    }

}