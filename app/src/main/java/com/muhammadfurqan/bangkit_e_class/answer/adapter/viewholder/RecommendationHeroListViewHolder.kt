package com.muhammadfurqan.bangkit_e_class.answer.adapter.viewholder

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkit_e_class.answer.Visitable
import com.muhammadfurqan.bangkit_e_class.answer.adapter.RecommendationHeroAdapter
import com.muhammadfurqan.bangkit_e_class.answer.model.RecommendationModel
import com.muhammadfurqan.bangkit_e_class.databinding.ItemRecommendationHeroListBinding

/**
 * @author by furqan on 18/03/2021
 */
class RecommendationHeroListViewHolder(private val binding: ItemRecommendationHeroListBinding) :
    BaseViewHolder(binding.root) {

    override fun bind(elements: Visitable) {
        val data = elements as RecommendationModel
        val adapter = RecommendationHeroAdapter(data.heroList)
        binding.rvHeroRecommendation.layoutManager =
            LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
        binding.rvHeroRecommendation.adapter = adapter
    }

}