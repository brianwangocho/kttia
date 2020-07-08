package com.example.budgetia.expenseui

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.budgetia.Repository.ExpensesRepository
import com.example.budgetia.dao.ExpensesDao
import com.example.budgetia.roomdatabase.MyRoomDatabase

class ExpenseViewModel (application: Application):ViewModel(){
    private var expenseDao : ExpensesDao = MyRoomDatabase.getDatabase(application).expensesDao()
    private var expensesRepository = ExpensesRepository( expenseDao)



}