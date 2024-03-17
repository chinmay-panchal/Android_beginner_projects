package com.example.fragments_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), Home.OnViewAllButtonClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
//        val viewAll = findViewById<Button>(R.id.viewAllButton) // this will won't work because we have to make an interface in the Home Fragment

        replaceWithFragment(Home())
//         Yeh first m start kardenge, jisse ki by default first page ya home page hi dikhe

        bottomView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> replaceWithFragment(Search())
                R.id.item2 -> replaceWithFragment(Category())
                R.id.item3 -> replaceWithFragment(Home())
                R.id.item4 -> replaceWithFragment(Cart())
                R.id.item5 -> replaceWithFragment(MyAccount())
                else -> {

                }
            }
            true
        }
    }

    private fun replaceWithFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    override fun onViewAllButtonClicked() {
        replaceWithFragment(Category())
    }
}