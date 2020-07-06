package com.example.budgetia.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.budgetia.models.ExpenseType


@Dao
interface ExpenseTypeDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun createExpenseType(expenseType: ExpenseType)


}