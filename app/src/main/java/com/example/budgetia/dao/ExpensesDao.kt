package com.example.budgetia.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.budgetia.models.Expenses

@Dao
interface ExpensesDao{
    ///get expenses
    @Query("SELECT * FROM expenses  ORDER BY created_on DESC")
    fun getAllexpenses(): LiveData<List<Expenses>>

    /// add an expense
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addExpense(expenses: Expenses)

    //delete Expense
    @Delete
    suspend fun deleteExpense(expenses: Expenses)

}