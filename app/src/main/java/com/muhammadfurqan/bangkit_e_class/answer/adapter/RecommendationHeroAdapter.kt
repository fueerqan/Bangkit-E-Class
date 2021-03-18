package com.muhammadfurqan.bangkit_e_class.answer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkit_e_class.answer.adapter.viewholder.RecommendationHeroViewHolder
import com.muhammadfurqan.bangkit_e_class.databinding.ItemRecommendationHeroBinding
import com.muhammadfurqan.bangkit_e_class.list.presentation.model.NationalHero

/**
 * @author by furqan on 18/03/2021
 */
class RecommendationHeroAdapter(private val dataList: List<NationalHero>) :
    RecyclerView.Adapter<RecommendationHeroViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendationHeroViewHolder =
        RecommendationHeroViewHolder(
            ItemRecommendationHeroBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RecommendationHeroViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

}