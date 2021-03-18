package com.muhammadfurqan.bangkit_e_class.answer.adapter.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide
import com.muhammadfurqan.bangkit_e_class.R
import com.muhammadfurqan.bangkit_e_class.answer.Visitable
import com.muhammadfurqan.bangkit_e_class.list.presentation.model.NationalHero
import de.hdodenhof.circleimageview.CircleImageView

/**
 * @author by furqan on 18/03/2021
 */
class AnswerNationalHeroViewHolder(view: View) :
    BaseViewHolder(view) {

    private var imageView: CircleImageView
    private var tvName: AppCompatTextView
    private var tvDescription: AppCompatTextView

    init {
        with(itemView) {
            imageView = findViewById(R.id.civ_hero)
            tvName = findViewById(R.id.tv_hero_name)
            tvDescription = findViewById(R.id.tv_hero_description)

        }
    }

    override fun bind(element: Visitable) {
        val hero = element as NationalHero
        tvName.text = hero.name
        tvDescription.text = hero.description

        Glide.with(itemView.context)
            .load(hero.imageUrl)
            .into(imageView)
    }

    companion object {
        val LAYOUT = R.layout.item_national_hero
    }
}