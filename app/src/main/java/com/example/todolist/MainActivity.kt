package com.example.todolist

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.todolist.ButtomNavigation_Fragment.*
import com.example.todolist.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener  {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.today_todo -> {
                binding2.mainText.setText("Today Todo")
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, Today_todo_Fragment())
                transaction.commit()
                return true
            }
            R.id.your_achievement -> {
                binding2.mainText.setText("Your Achievement")
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, Your_achievement())
                transaction.commit()
                return true
            }
            R.id.todo_add -> {
                binding2.mainText.setText("Todo Add")
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, Todo_Add())
                transaction.commit()
                return true
            }
            R.id.Your_today -> {
                binding2.mainText.setText("Your Today")
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, Your_Today())
                transaction.commit()
                return true
            }
            R.id.record -> {
                binding2.mainText.setText(item.itemId)
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, your_record())
                transaction.commit()
                return true
            }
        }
        return false
    }

    private var listview: RecyclerView? = null
    private lateinit var binding2 : ActivityMainBinding
    val snapHelper: SnapHelper = PagerSnapHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding2.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding2.recyclerView.adapter = MainAdapter()

//        //오늘의 todolist 보여지게하는 어뎁터와 네비게이션 불러오기
//        binding2.recyclerView.layoutManager = LinearLayoutManager(this)
          binding2.navigation.setOnNavigationItemSelectedListener(this)

        //리사이클러뷰의 속도가 null일경우 즉, 움직이지 않을경우 정의
        //움직이지 않을경우 다음 item으로 넘어감을 의미 따라서 다시 리사이클러뷰 변동사항 저장
        if (binding2.recyclerView.getOnFlingListener() == null)
            snapHelper.attachToRecyclerView(binding2.recyclerView)


        //recyclerView의 마지막 포지션을 반환해주어 체크하고 멈추게 한다.
        binding2.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
    }
}