package com.example.buttonnavigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.buttonnavigationexample.fragment.HomeFragment
import com.example.buttonnavigationexample.fragment.SettingFragment
import com.example.buttonnavigationexample.fragment.nOTIFICATIONFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val nOTIFICATIONFragment = nOTIFICATIONFragment()
        val settingFragment = SettingFragment()

        makeCurrentFragment (homeFragment)

        val bottom_navigation= findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_notification -> makeCurrentFragment(nOTIFICATIONFragment)
                R.id.menu_setting -> makeCurrentFragment(settingFragment)
            }

            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()

        }

    }
}