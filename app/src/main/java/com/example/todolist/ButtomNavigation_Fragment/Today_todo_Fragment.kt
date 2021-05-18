package com.example.todolist.ButtomNavigation_Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.*

class Today_todo_Fragment : Fragment() {


    //onCreateView로 View를 만들어주어야한다!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_today_todo,container,false)//프레그먼트 레이아웃 받아오는 부분

        view.findViewById<RecyclerView>(R.id.today_todo_recycler_view_imsy).adapter = Today_todoAdapter()
        view.findViewById<RecyclerView>(R.id.today_todo_recycler_view_imsy).layoutManager = LinearLayoutManager(activity)


        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        view?.findViewById<RecyclerView>(R.id.today_todo_recycler_view_imsy)?.layoutManager = LinearLayoutManager(requireContext())
        view?.findViewById<RecyclerView>(R.id.today_todo_recycler_view_imsy)?.adapter = Today_todoAdapter()
//
//        variable.binding2.todayTodoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//        variable.binding2.todayTodoRecyclerView.adapter = Today_todoAdapter()

    }
}