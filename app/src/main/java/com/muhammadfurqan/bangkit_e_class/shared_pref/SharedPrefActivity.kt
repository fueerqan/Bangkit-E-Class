package com.muhammadfurqan.bangkit_e_class.shared_pref

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.muhammadfurqan.bangkit_e_class.R

class SharedPrefActivity : AppCompatActivity() {

    private lateinit var etEmail: AppCompatEditText
    private lateinit var etPassword: AppCompatEditText
    private lateinit var btnLogin: AppCompatButton

    private lateinit var sharedPrefUtils: SharedPreferencesUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)

        sharedPrefUtils = SharedPreferencesUtils(
            getSharedPreferences(
                SharedPreferencesUtils.SHARED_PREF_NAME,
                Context.MODE_PRIVATE
            )
        )

        btnLogin.setOnClickListener {
            onLogin()
        }
    }

    private fun onLogin() {
        sharedPrefUtils.saveData(SharedPreferencesUtils.KEY_EMAIL, etEmail.text.toString())
        sharedPrefUtils.saveData(SharedPreferencesUtils.KEY_PASSWORD, etPassword.text.toString())
        sharedPrefUtils.saveData(SharedPreferencesUtils.KEY_IS_LOGGED_IN, true)
        sharedPrefUtils.apply()
    }
}