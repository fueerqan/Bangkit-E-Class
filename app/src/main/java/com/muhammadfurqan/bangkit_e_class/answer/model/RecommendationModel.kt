package com.muhammadfurqan.bangkit_e_class.answer.model

import com.muhammadfurqan.bangkit_e_class.answer.Visitable
import com.muhammadfurqan.bangkit_e_class.answer.adapter.AnswerAdapter
import com.muhammadfurqan.bangkit_e_class.list.presentation.model.NationalHero

/**
 * @author by furqan on 18/03/2021
 */
class RecommendationModel(val heroList: List<NationalHero>) : Visitable() {
    override fun getViewType(): Int = AnswerAdapter.RECOMMENDATION_TYPE
}