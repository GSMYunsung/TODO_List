package com.example.todolist

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.todolist.ButtomNavigation_Fragment.*
import com.example.todolist.DataClass.Data
import com.example.todolist.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

//싱글톤 패턴을 사용하면 좋은점.
//애플리케이션의 시작부터 종료까지 한 번의 생성으로 고정된 메모리 영역을 가지기 때문에 메모리를 효율적으로 사용 할 수 있다.
//싱글턴의 인스턴스는 전역적으로 사용되기 때문에 다른 클래스의 인스턴스들이 데이터를 공유 변경이 가능하다는 장점이 있다.
//쉽게 말하면 한 번의 선언으로 모든 클래스에서 전역으로 사용 가능한 필드나 메서드를 만드는 것. (아무데서나 접근 가능한 필드나 메소드) ex) 유저 로그인 아이디

class variable{
    companion object{
        var listview: RecyclerView? = null
        lateinit var binding2 : ActivityMainBinding
        val snapHelper: SnapHelper = PagerSnapHelper()
    }
}



class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener  {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.today_todo -> {
                variable.binding2.mainText.setText("Today Todo")
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, Today_todo_Fragment())
                transaction.commit()
                return true
            }
            R.id.your_achievement -> {
                variable.binding2.mainText.setText("Your Achievement")
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, Your_achievement())
                transaction.commit()
                return true
            }
            R.id.todo_add -> {
                variable.binding2.mainText.setText("Todo Add")
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, Todo_Add())
                transaction.commit()
                return true
            }
            R.id.Your_today -> {
                variable.binding2.mainText.setText("Your Today")
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, Your_Today())
                transaction.commit()
                return true
            }
            R.id.record -> {
                variable.binding2.mainText.setText(item.itemId)
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame, your_record())
                transaction.commit()
                return true
            }
        }
        return false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        variable.binding2 = DataBindingUtil.setContentView(this, R.layout.activity_main)

        First_today()

//        //오늘의 todolist 보여지게하는 어뎁터와 네비게이션 불러오기

        variable.binding2.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        variable.binding2.recyclerView.adapter = MainAdapter()


          variable.binding2.navigation.setOnNavigationItemSelectedListener(this)

        //리사이클러뷰의 속도가 null일경우 즉, 움직이지 않을경우 정의
        //움직이지 않을경우 다음 item으로 넘어감을 의미 따라서 다시 리사이클러뷰 변동사항 저장

        if (variable.binding2.recyclerView.getOnFlingListener() == null) variable.snapHelper.attachToRecyclerView(variable.binding2.recyclerView)

        variable.binding2.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = LinearLayoutManager::class.java.cast(recyclerView.layoutManager)
            }
        })

    }
    fun First_today(){
        variable.binding2.mainText.setText("Today Todo")
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, Today_todo_Fragment())
        transaction.commit()
    }
}

