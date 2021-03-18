package com.muhammadfurqan.bangkit_e_class.answer.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammadfurqan.bangkit_e_class.databinding.ItemRecommendationHeroBinding
import com.muhammadfurqan.bangkit_e_class.list.presentation.model.NationalHero

/**
 * @author by furqan on 18/03/2021
 */
class RecommendationHeroViewHolder(private val binding: ItemRecommendationHeroBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(element: NationalHero) {
        Glide.with(itemView.context)
            .load(element.imageUrl)
            .into(binding.civRecommendationHero)

        binding.tvHeroName.text = element.name
    }
}