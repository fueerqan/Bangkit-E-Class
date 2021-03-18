package com.muhammadfurqan.bangkit_e_class.answer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadfurqan.bangkit_e_class.answer.adapter.AnswerAdapter
import com.muhammadfurqan.bangkit_e_class.answer.model.RecommendationModel
import com.muhammadfurqan.bangkit_e_class.databinding.ActivityAnswerBinding
import com.muhammadfurqan.bangkit_e_class.list.data.DummyData

class AnswerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnswerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dummyData = arrayListOf<Visitable>(
            RecommendationModel(DummyData.HERO_DATA)
        )
        dummyData.addAll(DummyData.HERO_DATA)

        val adapter = AnswerAdapter(dummyData)
        binding.rvHeroRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.rvHeroRecyclerView.adapter = adapter
    }
}