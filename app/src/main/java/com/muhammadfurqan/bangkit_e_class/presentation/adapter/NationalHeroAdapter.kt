package com.muhammadfurqan.bangkit_e_class.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkit_e_class.presentation.adapter.viewholder.NationalHeroViewHolder
import com.muhammadfurqan.bangkit_e_class.presentation.model.NationalHero

/**
 * @author by furqan on 18/03/2021
 */
class NationalHeroAdapter(
    private val dataList: ArrayList<NationalHero>,
    private val listener: Listener
) : RecyclerView.Adapter<NationalHeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NationalHeroViewHolder =
        NationalHeroViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(NationalHeroViewHolder.LAYOUT, parent, false),
            listener
        )
    // Step 1 : Create Layout Inflater
    //  val layoutInflater = LayoutInflater.from(parent.context)
    // Step 2 : Inflate View
    //        val view = layoutInflater.inflate(NationalHeroViewHolder.LAYOUT, parent, false)
    // Step 3 : Create View Holder
    //        val viewHolder = NationalHeroViewHolder(view)
    // Step 4 : Return View Holder
    //        return viewHolder

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: NationalHeroViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    fun addData(newHero: ArrayList<NationalHero>) {
        val lastDataPosition = dataList.size
        dataList.addAll(newHero)
        notifyItemRangeInserted(lastDataPosition, newHero.size)
    }

    interface Listener {
        fun onClick(element: NationalHero)
    }

}