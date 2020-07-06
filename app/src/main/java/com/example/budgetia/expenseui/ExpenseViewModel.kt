package com.example.budgetia.expenseui

import androidx.lifecycle.ViewModel
import com.example.budgetia.Repository.ExpensesRepository


class ExpenseViewModel (private val expensesRepository: ExpensesRepository):ViewModel(){

    val expenses =  expensesRepository.allExpenses



}