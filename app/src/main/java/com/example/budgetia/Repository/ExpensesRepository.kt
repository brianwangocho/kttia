package com.example.budgetia.Repository

import androidx.lifecycle.LiveData
import com.example.budgetia.dao.ExpensesDao
import com.example.budgetia.models.Expenses

class ExpensesRepository(private val dao:ExpensesDao){
    val allExpenses = dao.getAllexpenses()

    suspend fun createExpense(expense:Expenses){
        dao.addExpense(expense)
    }
    suspend fun deleteExpense(expense: Expenses){
        dao.deleteExpense(expense)
    }
    fun getMyExpenses():LiveData<List<Expenses>> = dao.getAllexpenses()


}