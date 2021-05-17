package com.example.todolist.ButtomNavigation_Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.*

class Today_todo_Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        variable.binding2.todayTodoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        variable.binding2.todayTodoRecyclerView.adapter = Today_todoAdapter()

    }
}