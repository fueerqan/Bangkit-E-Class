package com.muhammadfurqan.bangkit_e_class.list.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkit_e_class.databinding.ActivityMainBinding
import com.muhammadfurqan.bangkit_e_class.fragment.FragmentActivity
import com.muhammadfurqan.bangkit_e_class.list.data.DummyData.HERO_DATA
import com.muhammadfurqan.bangkit_e_class.list.presentation.adapter.NationalHeroAdapter
import com.muhammadfurqan.bangkit_e_class.list.presentation.model.NationalHero

class MainActivity : AppCompatActivity(), NationalHeroAdapter.Listener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: NationalHeroAdapter

//    private lateinit var recyclerView: RecyclerView
//    private lateinit var btnAdd: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        btnAdd = findViewById(R.id.btn_add_data)
//        recyclerView = findViewById(R.id.rv_national_hero)

//        btnAdd.setOnClickListener {
//            adapter.addData(HERO_DATA)

        // navigate to fragment section
//            startActivity(Intent(this, FragmentActivity::class.java))
//        }

        binding.btnAddData.setOnClickListener {
            //            adapter.addData(HERO_DATA)

            // navigate to fragment section
            startActivity(Intent(this, FragmentActivity::class.java))
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
        binding.rvNationalHero.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvNationalHero.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        recyclerView.adapter = adapter
    }

    companion object {
        const val EXTRA_HERO = "EXTRA_HERO"
    }
}