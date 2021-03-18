package com.muhammadfurqan.bangkit_e_class.answer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkit_e_class.answer.Visitable
import com.muhammadfurqan.bangkit_e_class.answer.adapter.viewholder.AnswerNationalHeroViewHolder
import com.muhammadfurqan.bangkit_e_class.answer.adapter.viewholder.BaseViewHolder
import com.muhammadfurqan.bangkit_e_class.answer.adapter.viewholder.RecommendationHeroListViewHolder
import com.muhammadfurqan.bangkit_e_class.databinding.ItemRecommendationHeroListBinding

/**
 * @author by furqan on 18/03/2021
 */
class AnswerAdapter(
    private val dataList: List<Visitable>
) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        when (viewType) {
            HERO_TYPE -> AnswerNationalHeroViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(AnswerNationalHeroViewHolder.LAYOUT, parent, false)
            )
            RECOMMENDATION_TYPE -> RecommendationHeroListViewHolder(
                ItemRecommendationHeroListBinding.inflate(
                    LayoutInflater.from(parent.context)
                )
            )
            else -> AnswerNationalHeroViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(AnswerNationalHeroViewHolder.LAYOUT, parent, false)
            )
        }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemViewType(position: Int): Int =
        dataList[position].getViewType()

    companion object {
        const val HERO_TYPE = 1
        const val RECOMMENDATION_TYPE = 2
    }
}