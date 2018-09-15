package com.pratamawijaya.demomvp.data.repository

import com.pratamawijaya.demomvp.domain.User

interface UserRepository {
    fun getUser(): User
}