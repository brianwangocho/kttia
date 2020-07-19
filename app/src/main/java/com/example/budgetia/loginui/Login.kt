package com.example.budgetia.loginui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.example.budgetia.R
import com.example.budgetia.roomdatabase.MyRoomDatabase
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {


    private lateinit var userViewModel: UserViewModel

    private  val TAG = "LoginActivity"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        val factory =  UserViewModelFactory(application)
        userViewModel = ViewModelProviders.of(this,factory).get(UserViewModel::class.java)

        loginButton.setOnClickListener {
            if(validateInputs()){
                userViewModel.loginUser(login_username.text.toString(),login_password.text.toString())
            }
        }

    }

    private  fun validateInputs():Boolean{
        var isValid = true
        val username = login_username.text.toString()
        val password  = login_password.text.toString()
        if(username.isNullOrEmpty() ){
            login_username.setError("username cant be empty")
           isValid = false
        }
        if(password.isNullOrEmpty() ){
            login_password.setError("password cant be empty")
            isValid = false


        }
        return isValid

    }

}
