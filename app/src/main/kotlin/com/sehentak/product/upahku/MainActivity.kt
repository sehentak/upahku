package com.sehentak.product.upahku

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var mFragmentManager: FragmentManager
    private lateinit var mFragmentHome: HomeFragment
    private lateinit var mFragmentChart: ChartFragment
    private lateinit var mFragmentSalary: SalaryFragment
    private lateinit var mFragmentProfile: ProfileFragment
    private lateinit var mFragmentActive: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentInit()
        main_bn_navigation.itemIconTintList = null
        main_bn_navigation.setOnNavigationItemSelectedListener(this)
        main_bn_navigation.selectedItemId = R.id.menu_home
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_home -> mFragmentHome.applyToContainer()
            R.id.menu_salary -> mFragmentSalary.applyToContainer()
            R.id.menu_chart -> mFragmentChart.applyToContainer()
            R.id.menu_profile -> mFragmentProfile.applyToContainer()
            else -> false
        }
    }

    private fun Context.fragmentInit() {
        mFragmentHome = HomeFragment.getInstance()
        mFragmentSalary = SalaryFragment.getInstance()
        mFragmentChart = ChartFragment.getInstance()
        mFragmentProfile = ProfileFragment.getInstance()

        mFragmentHome.addToInstance(getString(R.string.menu_home))
        mFragmentSalary.addToInstance(getString(R.string.menu_salary))
        mFragmentChart.addToInstance(getString(R.string.menu_chart))
        mFragmentProfile.addToInstance(getString(R.string.menu_profile))
    }

    private fun Fragment.addToInstance(tag: String?){
        val transaction = checkInstance()
        transaction.add(R.id.main_fl_container, this, tag)
        transaction.hide(this)
        transaction.commit()
    }

    private fun Fragment.applyToContainer(): Boolean {
        if (!::mFragmentActive.isInitialized) mFragmentActive = this
        val transaction = checkInstance()
        transaction.hide(mFragmentActive)
        transaction.show(this)
        transaction.commit()
        mFragmentActive = this
        return true
    }

    private fun checkInstance(): FragmentTransaction {
        if (!::mFragmentManager.isInitialized) {
            mFragmentManager = supportFragmentManager
        }

        return mFragmentManager.beginTransaction()
    }
}