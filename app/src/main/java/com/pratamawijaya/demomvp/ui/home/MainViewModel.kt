package com.pratamawijaya.demomvp.ui.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.pratamawijaya.demomvp.data.model.TeamModel
import com.pratamawijaya.demomvp.data.repository.ArticleRepositoryImpl
import com.pratamawijaya.demomvp.domain.Article
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

sealed class MainState

data class ErrorState(var msg: String) : MainState()
object LoadingState : MainState()
data class TeamLoaded(val teams: List<TeamModel>) : MainState()


class MainViewModel : ViewModel() {

    var mainState = MutableLiveData<MainState>()

    private var articleRepo: ArticleRepositoryImpl

    var listTeam = MutableLiveData<List<TeamModel>>()

    init {
        articleRepo = ArticleRepositoryImpl()
    }

    var articleLiveData = MutableLiveData<List<Article>>()


    fun getTeams() {
        mainState.value = LoadingState

        articleRepo.getAllTeams(4490)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    mainState.value = TeamLoaded(result)
                }, { error ->
                    mainState.value = ErrorState(error.localizedMessage)

                    Log.e("error", "errornya ${error.localizedMessage}")
                })
    }

    fun getArticle() {
        articleRepo.getArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    articleLiveData.value = result
                })
    }

}