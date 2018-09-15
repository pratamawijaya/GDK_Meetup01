package com.pratamawijaya.demomvp.data.repository

import com.pratamawijaya.demomvp.data.model.UserModel
import com.pratamawijaya.demomvp.domain.User

class UserRepositoryImpl : UserRepository {

    override fun getUser(): User {
        // mau ambil data user darimana ?
        val userModel = UserModel("Pratama", "wijaya", email = "mail@com")

        return User(
                "${userModel.firstName} ${userModel.lastName}",
                userModel.email
        )
    }
}