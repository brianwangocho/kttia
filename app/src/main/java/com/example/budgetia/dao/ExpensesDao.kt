package com.example.budgetia.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.budgetia.models.Expenses

@Dao
interface ExpensesDao{
    ///get expenses
    @Query("SELECT * FROM expenses  ORDER BY created_on DESC")
    fun getAllexpenses(): List<Expenses>

    /// add an expense
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addExpense(expenses: Expenses)

    //

}