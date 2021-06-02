package com.cloudless.paypay.data.source.local

import android.content.Context
import android.content.SharedPreferences

class Preference (private val context: Context) {
    private val prefs: SharedPreferences

    var isLoggedIn: Boolean
        get() = prefs.getBoolean(IS_LOGGED_IN, false)
        set(input) {
            val editor = prefs.edit()
            editor.putBoolean(IS_LOGGED_IN, input)
            editor.apply()
        }

    var userId: String?
        get() = prefs.getString(USER_ID, "null")
        set(value) {
            val editor = prefs.edit()
            editor.putString(USER_ID, value.toString())
            editor.apply()
        }

    companion object {
        private const val PREFS_NAME = "AppPref"
        private const val IS_LOGGED_IN = "is_logged_in"
        private const val USER_ID = "user_id"
    }

    init {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
}