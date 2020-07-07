package com.example.budgetia.expenseui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.budgetia.Repository.ExpensesRepository
import java.lang.IllegalArgumentException

class ExpenseViewModelFactory(private val expensesRepository: ExpensesRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ExpenseViewModel::class.java)){
            return ExpenseViewModel(expensesRepository) as  T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }

}