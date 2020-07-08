package com.example.budgetia.expenseui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.budgetia.Repository.ExpensesRepository
import java.lang.IllegalArgumentException

class ExpenseViewModelFactory(private val mApplication: Application):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return ExpenseViewModel(mApplication) as T
    }

}