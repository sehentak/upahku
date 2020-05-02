package com.sehentak.product.upahku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment: Fragment() {

    companion object {
        @Volatile private lateinit var instanceFragment: HomeFragment

        fun getInstance(): HomeFragment {
            if (!::instanceFragment.isInitialized) {
                instanceFragment = HomeFragment()
            }
            return instanceFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textViewName = view.findViewById<TextView>(R.id.home_tv_name)
        textViewName.text = getString(R.string.menu_home)
    }
}