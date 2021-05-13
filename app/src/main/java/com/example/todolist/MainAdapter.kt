package com.example.todolist

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.DataClass.Data
import org.w3c.dom.Text

class MainAdapter : RecyclerView.Adapter<MainAdapter.ItemViewHolder>() {

    var items: MutableList<Data> = mutableListOf(Data("하루에 한번 스트레칭", "미달성"),
            Data("잠 8시간 이상자기", "달성"), Data("자격증 공부하기", "미달성"))


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
      return ItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        items[position].let { item ->
            with(holder){
                todotitle.text = item.todoName
                todoAchievement.text = item.todoAchievement
            }
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }

    inner class ItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.todo_item,parent,false)){
        val todotitle = itemView.findViewById<TextView>(R.id.todo_List_item_titleText)
        val todoAchievement = itemView.findViewById<TextView>(R.id.Achievement)
    }

}