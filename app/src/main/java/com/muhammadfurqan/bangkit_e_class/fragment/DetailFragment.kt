package com.muhammadfurqan.bangkit_e_class.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.muhammadfurqan.bangkit_e_class.R
import com.muhammadfurqan.bangkit_e_class.list.presentation.model.NationalHero

/**
 * @author by furqan on 18/03/2021
 */
class DetailFragment : Fragment() {

    private lateinit var tvName: AppCompatTextView

    private lateinit var heroData: NationalHero

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvName = view.findViewById(R.id.tv_hero_name)

        heroData = arguments?.getParcelable(FragmentActivity.ARG_HERO) ?: NationalHero()
        tvName.text = heroData.description
    }

}