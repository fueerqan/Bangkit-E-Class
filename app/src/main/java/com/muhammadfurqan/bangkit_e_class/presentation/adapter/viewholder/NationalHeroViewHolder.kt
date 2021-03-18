package com.muhammadfurqan.bangkit_e_class.presentation.adapter.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammadfurqan.bangkit_e_class.R
import com.muhammadfurqan.bangkit_e_class.presentation.adapter.NationalHeroAdapter
import com.muhammadfurqan.bangkit_e_class.presentation.model.NationalHero
import de.hdodenhof.circleimageview.CircleImageView

/**
 * @author by furqan on 18/03/2021
 */
class NationalHeroViewHolder(view: View, val listener: NationalHeroAdapter.Listener) :
    RecyclerView.ViewHolder(view) {

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

    fun bind(element: NationalHero) {
        tvName.text = element.name
        tvDescription.text = element.description

        Glide.with(itemView.context)
            .load(element.imageUrl)
            .into(imageView)

        itemView.setOnClickListener {
            listener.onClick(element)
        }
    }

    companion object {
        val LAYOUT = R.layout.item_national_hero
    }
}