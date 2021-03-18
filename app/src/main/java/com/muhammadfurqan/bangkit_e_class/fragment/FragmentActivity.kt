package com.muhammadfurqan.bangkit_e_class.fragment

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.muhammadfurqan.bangkit_e_class.R
import com.muhammadfurqan.bangkit_e_class.list.presentation.model.NationalHero

class FragmentActivity : AppCompatActivity(), HeroListFragment.FragmentListener {

    private lateinit var fragmentContainer: FrameLayout

    private lateinit var heroListFragment: HeroListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        fragmentContainer = findViewById(R.id.fragment_container)

        heroListFragment = HeroListFragment()
        heroListFragment.listener = this

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, heroListFragment)
            .commit()
    }

    override fun onClick(element: NationalHero) {
        val bundle = Bundle()
        bundle.putParcelable(ARG_HERO, element)

        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailFragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        const val ARG_HERO = "ARG_HERO"
    }
}