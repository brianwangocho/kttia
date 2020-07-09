package com.example.budgetia.expenseui

import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetia.R
import com.example.budgetia.models.Expenses

import kotlinx.android.synthetic.main.expenses_card.view.*

class ExpenseRecyclerViewAdapter(private val expenseslist: List<Expenses>) : RecyclerView.Adapter<ExpenseRecyclerViewAdapter.ExpensesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.expenses_card,parent,false)

        return ExpensesViewHolder(itemView)
    }

    override fun getItemCount() = expenseslist.size


    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
     val  currentItem = expenseslist[position]

        holder.expenseAmount.text = currentItem.amount.toString()
        holder.expenseDate.text = currentItem.created_on.toString()
        holder.expense.text= currentItem.name
    }


    ///// create a viewholder
    class ExpensesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView :ImageView = itemView.expense_image
        val expense:TextView = itemView.expense
        val  expenseDate:TextView = itemView.expense_date
        val expenseAmount:TextView = itemView.expense_amount


    }

}