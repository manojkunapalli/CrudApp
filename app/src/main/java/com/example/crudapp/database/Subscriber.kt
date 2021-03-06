package com.example.crudapp.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subscriber_data_table")
data class Subscriber(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "subscriber_name")
    val id : Int,

    @ColumnInfo(name = "subscriber_name")
    val name : String,

    @ColumnInfo(name = "subscriber_email")
    val email : String
)

// data class represents all variables with getters and setters