package com.example.budgetia.models

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.budgetia.util.DateConvertor
import java.util.*

@Entity(tableName = "expenses")
data class Expenses(

    @ColumnInfo(name="type") val type:Int,
    @ColumnInfo(name="name") val name:String,
    @ColumnInfo(name="amount") val amount:Int,
    @ColumnInfo(name="created_by") val created_by:Int,
    @TypeConverters(DateConvertor::class)
    @ColumnInfo(name="created_on")val created_on:Date

){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id: Long  = 0

    constructor() : this(0, "",0, 0,  Date())

}