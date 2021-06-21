package com.example.todolist.Room_Database

import androidx.room.*

@Dao
interface TodoDaoClass {

    @Query("SELECT * FROM todolist ORDER BY id DESC")
    fun AllTodoList() : List<TodoEntitiyClsss>

    @Insert
    fun TodoInstert(entitiy : TodoEntitiyClsss?)

    @Update
    fun TodoUpdate(entitiy: TodoEntitiyClsss?)

    @Delete
    fun TodoDelete(entitiy: TodoEntitiyClsss?)
}