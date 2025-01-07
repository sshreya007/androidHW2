package com.example.myapplication.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityNavigationBinding
import com.example.myapplication.ui.fragment.HomeFragment
import com.example.myapplication.ui.fragment.NotificationFragment
import com.example.myapplication.ui.fragment.ProfileFragment
import com.example.myapplication.ui.fragment.SearchFragment

class NavigationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding =ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

       replaceFragment(HomeFragment())

        binding.bottomView.setOnItemSelectedListener { when(it.itemId){
            R.id.navHome -> replaceFragment(HomeFragment())
                R.id.navSearch ->replaceFragment(SearchFragment())
                    R.id.navNotification ->replaceFragment(NotificationFragment())
                        R.id.navprofile ->replaceFragment(ProfileFragment())
                            else ->{}
        }
            true
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }


        }
    private fun replaceFragment(fragment: Fragment) {
        val  fragmentManager :FragmentManager=supportFragmentManager

        val fragmentTransaction: FragmentTransaction=fragmentManager.beginTransaction()

        fragmentTransaction.replace(binding.frameBottom.id,fragment)

        fragmentTransaction.commit()
    }
}
