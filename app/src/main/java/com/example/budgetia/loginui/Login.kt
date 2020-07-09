package com.example.budgetia.loginui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.budgetia.Dashboard
import com.example.budgetia.R
import com.example.budgetia.databinding.ActivityLoginBinding
import com.example.budgetia.expenseui.ExpenseViewModel
import com.example.budgetia.roomdatabase.MyRoomDatabase
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val userDao = MyRoomDatabase.getDatabase(application).userDao()

        val factory =  UserViewModelFactory(application)
        userViewModel = ViewModelProviders.of(this,factory).get(UserViewModel::class.java)
        binding.userviewmodel = userViewModel
        binding.lifecycleOwner=this







    }

}
