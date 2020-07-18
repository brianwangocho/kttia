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
    private  var username: TextInputLayout? = null
    private  var password: TextInputLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
         username = findViewById(R.id.login_username) as TextInputLayout
         password = findViewById(R.id.login_password) as TextInputLayout


        val factory =  UserViewModelFactory(application)
        userViewModel = ViewModelProviders.of(this,factory).get(UserViewModel::class.java)

        loginButton.setOnClickListener {
            if(validateInputs()){

            }

        }

    }

    private  fun validateInputs():Boolean{
        val c = username.toString().trim()
        Log.d(TAG,"username is  $username")



        return true

    }

}
