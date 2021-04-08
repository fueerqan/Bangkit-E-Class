package com.muhammadfurqan.bangkit_e_class

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.muhammadfurqan.bangkit_e_class.list.presentation.activity.MainActivity
import com.muhammadfurqan.bangkit_e_class.shared_pref.SharedPrefActivity

class BaseActivity : AppCompatActivity() {

    private lateinit var btnGoToList: AppCompatButton
    private lateinit var btnGoToSharedPref: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        btnGoToList = findViewById(R.id.btn_go_to_list)
        btnGoToList.setOnClickListener {
            goToList()
        }

        btnGoToSharedPref = findViewById(R.id.btn_go_to_shared_pref)
        btnGoToSharedPref.setOnClickListener {
            goToSharedPref()
        }
    }

    private fun goToList() {
        startActivity(
            Intent(this, MainActivity::class.java)
        )
    }

    private fun goToSharedPref() {
        startActivity(
            Intent(this, SharedPrefActivity::class.java)
        )
    }
}