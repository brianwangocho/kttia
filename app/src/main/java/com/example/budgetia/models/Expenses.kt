package com.example.budgetia.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "expenses")
class Expenses(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name="type") val email:Int,
    @ColumnInfo(name="amount") val amount:Float,
    @ColumnInfo(name="created_by") val created_by:Int,
    @ColumnInfo(name="created_on")val created_on:Date

)