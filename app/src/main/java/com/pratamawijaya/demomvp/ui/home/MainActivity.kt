package com.pratamawijaya.demomvp.ui.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.pratamawijaya.demomvp.R
import com.pratamawijaya.demomvp.data.PrefHelper
import com.pratamawijaya.demomvp.data.model.TeamModel
import com.pratamawijaya.demomvp.data.repository.ArticleRepositoryImpl
import com.pratamawijaya.demomvp.data.repository.UserRepositoryImpl
import com.pratamawijaya.demomvp.domain.Article
import com.pratamawijaya.demomvp.ui.home.item.ArticleAnother
import com.pratamawijaya.demomvp.ui.home.item.ArticleHorizontalItem
import com.pratamawijaya.demomvp.ui.home.item.ArticleItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.rvArticle

class MainActivity : AppCompatActivity() {

    // declare presenter
    lateinit var presenter: MainPresenter

    lateinit var vm: MainViewModel

    private var articleAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = UserRepositoryImpl()
        val articleRepo = ArticleRepositoryImpl()
        val prefHelper = PrefHelper(this)

        vm = ViewModelProviders.of(this).get(MainViewModel::class.java)
        vm.articleLiveData.observe(this, observer)


        vm.mainState.observe(this, stateObserver)
        vm.getTeams()

//        vm.getArticle()

        rvArticle.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = articleAdapter
        }

    }

    val stateObserver = Observer<MainState> { state ->

        when (state) {
            is LoadingState -> {
                // ngapain
                Log.d("tag", "loading")
            }

            is ErrorState -> {
                // ngapain
                Log.d("tag", "error ${state.msg}")
            }

            is TeamLoaded -> {
                state.teams.map {
                    Log.d("tag", "datanya ${it.idTeam}")
                }
            }
        }

    }

    val listTeamObserver = Observer<List<TeamModel>> { teams ->
        teams?.map {
            Log.d("data", "data team $it.str")
        }
    }

    val observer = Observer<List<Article>> { data ->
        data?.map {
            articleAdapter.add(ArticleItem(it))
        }
        val horizontalAdpter = GroupAdapter<ViewHolder>()
        data?.map {
            horizontalAdpter.add(ArticleAnother(it))
        }
        articleAdapter.add(ArticleHorizontalItem(horizontalAdpter))
    }

}
