package com.muhammadfurqan.bangkit_e_class.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammadfurqan.bangkit_e_class.R
import com.muhammadfurqan.bangkit_e_class.list.data.DummyData
import com.muhammadfurqan.bangkit_e_class.list.presentation.adapter.NationalHeroAdapter
import com.muhammadfurqan.bangkit_e_class.list.presentation.model.NationalHero

/**
 * @author by furqan on 18/03/2021
 */
class HeroListFragment : Fragment(), NationalHeroAdapter.Listener {

    lateinit var listener: FragmentListener

    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: NationalHeroAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_first, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_hero_fragment)
        setupRecyclerView()
    }

    override fun onClick(element: NationalHero) {
        listener.onClick(element)
    }

    private fun setupRecyclerView() {
        adapter = NationalHeroAdapter(DummyData.HERO_DATA, this)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    interface FragmentListener {
        fun onClick(element: NationalHero)
    }

}