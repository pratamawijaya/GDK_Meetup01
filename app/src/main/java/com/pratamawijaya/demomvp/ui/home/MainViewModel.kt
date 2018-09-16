package com.pratamawijaya.demomvp.ui.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.pratamawijaya.demomvp.data.repository.ArticleRepositoryImpl
import com.pratamawijaya.demomvp.domain.Article
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {

    private var articleRepo: ArticleRepositoryImpl

    init {
        articleRepo = ArticleRepositoryImpl()
    }

    var articleLiveData = MutableLiveData<List<Article>>()


    fun getArticle() {
        articleRepo.getArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    articleLiveData.value = result
                })
    }

}