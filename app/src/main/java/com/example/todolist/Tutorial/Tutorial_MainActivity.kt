package com.example.todolist.Tutorial

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.example.todolist.ButtomNavigation_Fragment.*
import com.example.todolist.MainActivity
import com.example.todolist.R
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.databinding.ActivityTutorialMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class Tutorial_MainActivity : AppCompatActivity(){

    private lateinit var binding : ActivityTutorialMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tutorial__main)

        //setContentView(R.layout.activity_tutorial__main)
        binding.tutorialBottom.setOnClickListener {
            binding.mViewPager.setCurrentItem(getItem(+1), true) }
        binding.mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.tutorialBottom.setText("NEXT")
                    }
                    1 -> {
                        binding.tutorialBottom.setText("NEXT")
                    }
                    2 -> {
                        binding.tutorialBottom.setText("START")
                        binding.tutorialBottom.setOnClickListener {
                            startActivity(Intent(this@Tutorial_MainActivity,MainActivity::class.java))
                        }
                    }
                }
            }
        })
        binding.mViewPager.adapter = Tutorial_Adapter(supportFragmentManager)
        binding.mViewPager.offscreenPageLimit = 2
    }

    private fun getItem(i: Int): Int {
        return binding.mViewPager.getCurrentItem() + i
    }

}