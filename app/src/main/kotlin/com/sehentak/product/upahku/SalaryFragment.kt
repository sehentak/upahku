package com.sehentak.product.upahku

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
        val createButton = view.findViewById<FloatingActionButton>(R.id.salary_fab_create)

        toolbarView.title = getString(R.string.menu_salary)
        createButton.setOnClickListener {
            val intent = Intent(activity, CreateActivity::class.java)
            startActivity(intent)
        }
    }
}