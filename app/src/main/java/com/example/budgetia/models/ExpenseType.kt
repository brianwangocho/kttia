package com.example.budgetia.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "expense_type")
class ExpenseType (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name="bill_type_flag") val bill_type_flag:Int,
    @ColumnInfo(name="bill_name") val bill_name:Float
)