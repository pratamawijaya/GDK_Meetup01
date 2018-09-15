package com.pratamawijaya.demomvp.data

import android.content.Context
import android.content.SharedPreferences

class PrefHelper(context: Context) {
    private val sharedPref: SharedPreferences

    companion object {
        val PREF_NAME = "baseapp"
        val PREF_USERNAME = "username"
        val PREF_USER_IS_LOGIN = "userislogin"
        val PREF_TOKEN = "auth_token"
    }

    init {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun clear() {
        sharedPref.edit().clear().apply()
    }

    fun saveString(key: String, value: String) {
//        Log.d { "save $value to $key" }
        val editor = sharedPref.edit()
        editor.putString(key, value)
        editor.commit()
    }

    fun getString(key: String): String = sharedPref.getString(key, "")

}