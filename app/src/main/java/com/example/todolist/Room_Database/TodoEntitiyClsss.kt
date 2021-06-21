package com.example.todolist.Room_Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todolist")
data class TodoEntitiyClsss (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id : Int? = 0,
    @ColumnInfo(name = "title") val title : String?,
    @ColumnInfo(name = "writing") val writing : String?,
    @ColumnInfo(name = "achievement") val achievement : Boolean
)