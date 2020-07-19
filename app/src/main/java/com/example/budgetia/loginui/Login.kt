package com.example.budgetia.loginui


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.budgetia.R
import com.example.budgetia.roomdatabase.MyRoomDatabase
import com.google.android.material.snackbar.Snackbar
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
          val c =  userViewModel.authenticateUser(login_username.toString(),login_password.toString())
                Log.i(TAG,"COUNT IS  $c")


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
