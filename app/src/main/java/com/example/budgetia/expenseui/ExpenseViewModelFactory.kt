package com.example.budgetia.expenseui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ExpenseViewModelFactory(private  val application: Application):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ExpenseViewModel(application) as T
    }

}