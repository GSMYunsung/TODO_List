package com.example.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.DataClass.Data

class Today_todoAdapter : RecyclerView.Adapter<Today_todoAdapter.ItemViewHolder>() {

    var items: MutableList<Data> = mutableListOf(Data("하루에 한번 스트레칭","미달성","아리아리 스리스리 아라리로 아리랑 고개로 넘어간"),
            Data("잠 8시간 이상자기", "달성","아리아리 스리스리 아라리로 아리랑 고개로 넘어간"), Data("전공책 읽고 복습하기", "미달성","아리아리 스리스리 아라리로 아리랑 고개로 넘어간"))


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        items[position].let { item ->
            with(holder){
                todotitle.text = item.todoName
                todoAchievement.text = item.todoAchievement
                todoexplain.text = item.todoexplain
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.today_todo_item,parent,false)){
        val todotitle = itemView.findViewById<TextView>(R.id.today_todo_list_title)
        val todoAchievement = itemView.findViewById<TextView>(R.id.today_todo_Achievement)
        val todoexplain = itemView.findViewById<TextView>(R.id.today_todo_list_explain)
    }

}