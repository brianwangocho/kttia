package com.example.budgetia.expenseui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.budgetia.R
import com.example.budgetia.Repository.ExpensesRepository
import com.example.budgetia.dao.ExpensesDao

/**
 * A simple [Fragment] subclass.
 */
class ExpensesFragment : Fragment() {


    private lateinit var expenseViewModel: ExpenseViewModel
    private lateinit var factory: ExpenseViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val factory = ExpenseViewModelFactory(activity!!.application)
        expenseViewModel =
            ViewModelProviders.of(this, factory).get(expenseViewModel::class.java)


        val root = inflater.inflate(R.layout.fragment_expenses, container, false)




        return root
    }


}
