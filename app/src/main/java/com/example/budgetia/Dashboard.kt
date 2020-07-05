package com.example.budgetia

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {

    /// fragments
    lateinit var  homeFragment: DashFragment
    lateinit var  profileFragment: ProfileFragment
    lateinit var settingsFragment: SettingsFragment
    lateinit var  expensesFragment: ExpensesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

//        make home the default view when app opens

        homeFragment = DashFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout,homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


//        bottom navigation on selected
        bottom_nav.setOnNavigationItemSelectedListener { item ->

            when(item.itemId){

                R.id.home ->{
                    homeFragment = DashFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.profile ->{
                    profileFragment = ProfileFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.expenses ->{
                    expensesFragment  = ExpensesFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,expensesFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.settings ->{
                    settingsFragment = SettingsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,settingsFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

            }
            true
        }




    }
}
