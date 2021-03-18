package com.muhammadfurqan.bangkit_e_class.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.muhammadfurqan.bangkit_e_class.R
import com.muhammadfurqan.bangkit_e_class.presentation.model.NationalHero

class DetailActivity : AppCompatActivity() {

    private lateinit var tvName: AppCompatTextView

    private lateinit var hero: NationalHero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvName = findViewById(R.id.tv_hero_name)

        hero = intent.getParcelableExtra(MainActivity.EXTRA_HERO) ?: NationalHero()

        tvName.text = hero.name
    }
}