package com.pratamawijaya.demomvp.data.repository

import com.pratamawijaya.demomvp.data.model.TeamModel
import com.pratamawijaya.demomvp.domain.Article
import io.reactivex.Single

interface ArticleRepository {
    fun getArticles(): Single<List<Article>>
    fun getAllTeams(leagueId: Int): Single<List<TeamModel>>
}