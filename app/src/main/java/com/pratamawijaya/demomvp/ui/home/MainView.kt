package com.pratamawijaya.demomvp.ui.home

import com.pratamawijaya.demomvp.domain.User

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showUserData(user: User)
}