package com.muhammadfurqan.bangkit_e_class.answer.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkit_e_class.answer.Visitable

/**
 * @author by furqan on 18/03/2021
 */
abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(element: Visitable)

}