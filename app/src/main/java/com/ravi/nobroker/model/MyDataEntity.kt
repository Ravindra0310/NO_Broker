package com.example.guessmyage.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_data_table")
data class MyDataEntity(
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "title") val title : String,
    @ColumnInfo(name = "subTitle") val subTitle: String) {

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int? = null
}