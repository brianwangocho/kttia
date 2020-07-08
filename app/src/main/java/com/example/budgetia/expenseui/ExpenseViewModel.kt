package com.example.budgetia.expenseui

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.budgetia.Repository.ExpensesRepository
import com.example.budgetia.roomdatabase.MyRoomDatabase


class ExpenseViewModel (application: Application):ViewModel(){
    val expenseDao = MyRoomDatabase.getDatabase(application).expensesDao()
    private var expensesRepository = ExpensesRepository(expenseDao)
    val expenses = expensesRepository.allExpenses






}