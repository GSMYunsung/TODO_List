package com.example.todolist.Room_Database

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoEntitiyClsss::class],version = 1)
abstract class TodoRoomDataBase : RoomDatabase() {
    abstract fun TodoDao() : TodoDaoClass

    companion object{
        private var DataBaseInstance : TodoRoomDataBase? = null

        @Synchronized
        fun getDataBase(context : Context) : TodoRoomDataBase? {
            if(DataBaseInstance == null){
                DataBaseInstance = Room.databaseBuilder<TodoRoomDataBase>(
                    context.applicationContext,TodoRoomDataBase::class.java,"AppDB")
                    .allowMainThreadQueries()
                    .build()
            }
            return DataBaseInstance
        }
    }
}