package com.example.budgetia.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "expense_type")
data class ExpenseType (

    @ColumnInfo(name="bill_type_flag") val bill_type_flag:Int,
    @ColumnInfo(name="bill_name") val bill_name:String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id: Long  = 0

    constructor() : this(0, "")
}