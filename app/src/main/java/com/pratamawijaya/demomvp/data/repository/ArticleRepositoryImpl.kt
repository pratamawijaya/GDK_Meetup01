package com.pratamawijaya.demomvp.data.repository

import android.util.Log
import com.google.gson.Gson
import com.pratamawijaya.demomvp.data.model.ArticleModel
import com.pratamawijaya.demomvp.data.model.TeamModel
import com.pratamawijaya.demomvp.data.model.response.AllTeamResponse
import com.pratamawijaya.demomvp.data.model.response.ArticleResponse
import com.pratamawijaya.demomvp.domain.Article
import io.reactivex.Single
import java.net.URL
import java.util.*

class ArticleRepositoryImpl : ArticleRepository {

    override fun getArticles(): Single<List<Article>> {
        //
        val url = "https://gist.githubusercontent.com/pratamawijaya/a833ce77dc6f599fc5ddbc0907ff56f9/raw/427fa532a2a7ca118a823a3a0132cd2c0ef82227/news.json"

        val single = Single.create<List<Article>> {

            val responseString = URL(url).readText()
            Log.d("tag", "hasil url $responseString")
            // transform json string to pojo

            try {
                val articleResponse = Gson().fromJson(responseString, ArticleResponse::class.java)

                Log.d("tag", " ukuran artikel ${articleResponse.articles.size}")
                val articlesModel = articleResponse.articles

                var articles: MutableList<Article> = mutableListOf()

                articlesModel.map {
                    articles.add(mapToDomain(it))
                }

                it.onSuccess(articles)
            } catch (e: Exception) {
                Log.e("tag", "error ${e.localizedMessage}")
                it.onError(e)
            }

        }

        return single
    }

    override fun getAllTeams(leagueId: Int): Single<List<TeamModel>> {
        val url = "https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php?id=$leagueId"

        val single = Single.create<List<TeamModel>> {
            val responseString = URL(url).readText()
            Log.d("tag", "hasil url $responseString")
            // transform json string to pojo

            try {
                val teamResponse = Gson().fromJson(responseString, AllTeamResponse::class.java)
                Log.d("tag", "response ${teamResponse.teams?.size}")

                val team = mutableListOf<TeamModel>()
                teamResponse.teams?.map {
                    team.add(it)
                }
                it.onSuccess(team)
            } catch (err: Exception) {
                it.onError(err)
            }
        }
        return single
    }

    // map to domain
    fun mapToDomain(model: ArticleModel): Article {
        Log.d("tag", "mapping article ${model.title}")
        return Article(
                title = model.title,
                image = model.urlToImage ?: "",
                desc = model.description,
                author = model.author,
                date = Date()
        )
    }
}