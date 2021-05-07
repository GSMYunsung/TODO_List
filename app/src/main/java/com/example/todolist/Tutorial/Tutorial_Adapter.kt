@file:Suppress("DEPRECATION")

package com.example.todolist.Tutorial

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.todolist.MainActivity
import com.example.todolist.R
import com.example.todolist.databinding.ActivityTutorialMainBinding
class Tutorial_Adapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {

        return when (position){
            0       ->  {tutorial_page_1()}

            1       ->  tutorial_page_2()

            else    ->  tutorial_page_3()

        }
    }
}