package com.sehentak.product.upahku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar

class SalaryFragment: Fragment() {

    companion object {
        @Volatile private lateinit var instanceFragment: SalaryFragment

        fun getInstance(): SalaryFragment {
            if (!::instanceFragment.isInitialized) {
                instanceFragment = SalaryFragment()
            }
            return instanceFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_salary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbarView = view.findViewById<MaterialToolbar>(R.id.app_toolbar)
        val textViewName = view.findViewById<TextView>(R.id.salary_tv_name)

        toolbarView.title = getString(R.string.menu_salary)
        textViewName.text = getString(R.string.menu_salary)
    }
}