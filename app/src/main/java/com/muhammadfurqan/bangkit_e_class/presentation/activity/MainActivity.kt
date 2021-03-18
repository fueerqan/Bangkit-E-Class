package com.muhammadfurqan.bangkit_e_class.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkit_e_class.R
import com.muhammadfurqan.bangkit_e_class.data.DummyData.HERO_DATA
import com.muhammadfurqan.bangkit_e_class.presentation.adapter.NationalHeroAdapter
import com.muhammadfurqan.bangkit_e_class.presentation.model.NationalHero

class MainActivity : AppCompatActivity(), NationalHeroAdapter.Listener {

    private lateinit var adapter: NationalHeroAdapter

    private lateinit var recyclerView: RecyclerView
    private lateinit var btnAdd: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btn_add_data)
        recyclerView = findViewById(R.id.rv_national_hero)

        btnAdd.setOnClickListener {
            adapter.addData(HERO_DATA)
        }

        setupRecyclerView()
    }

    override fun onClick(element: NationalHero) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(EXTRA_HERO, element)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        adapter = NationalHeroAdapter(HERO_DATA, this)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    companion object {
        const val EXTRA_HERO = "EXTRA_HERO"
    }
}