package com.muhammadfurqan.bangkit_e_class.shared_pref

import android.content.SharedPreferences

/**
 * @author by furqan on 08/04/2021
 */
class SharedPreferencesUtils(private val sharedPreferences: SharedPreferences) {

    private val editor = sharedPreferences.edit()

    fun saveData(key: String, value: Any) {
        when (value) {
            is String -> {
                editor.putString(key, value)
            }
            is Boolean -> {
                editor.putBoolean(key, value)
            }
            else -> {
                throw Throwable("Data Type is not Supported")
            }
        }
    }

    fun getData(key: String, default: Boolean): Boolean =
        sharedPreferences.getBoolean(key, default)

    fun getData(key: String, default: String): String =
        sharedPreferences.getString(key, default) ?: default

    fun apply() {
        editor.apply()
    }

    companion object {
        const val SHARED_PREF_NAME = "bangkit_e_session"

        const val KEY_EMAIL = "email"
        const val KEY_PASSWORD = "password"
        const val KEY_IS_LOGGED_IN = "isLoggedIn"
    }
}