package com.sehentak.product.upahku

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar

class ProfileFragment: Fragment() {

    companion object {
        @Volatile private lateinit var instanceFragment: ProfileFragment

        fun getInstance(): ProfileFragment {
            if (!::instanceFragment.isInitialized) {
                instanceFragment = ProfileFragment()
            }
            return instanceFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    @Suppress("DEPRECATION")
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbarView = view.findViewById<MaterialToolbar>(R.id.app_toolbar)
        val textVersion = view.findViewById<TextView>(R.id.profile_tv_version)

        toolbarView.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        toolbarView.title = getString(R.string.menu_profile)
        toolbarView.setTitleTextColor(resources.getColor(android.R.color.white))
        textVersion.text = "v${BuildConfig.VERSION_NAME}"
    }
}