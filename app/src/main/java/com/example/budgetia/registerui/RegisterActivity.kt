package com.example.budgetia.registerui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.budgetia.R
import com.example.budgetia.loginui.Login
import com.example.budgetia.loginui.UserViewModel
import com.example.budgetia.loginui.UserViewModelFactory
import com.example.budgetia.models.User
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.login_username_layout
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel

    private  val TAG = "RegisterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val factory =  UserViewModelFactory(application)
        userViewModel = ViewModelProviders.of(this,factory).get(UserViewModel::class.java)




        signupButton.setOnClickListener {
            if(validateInputs()){
                if(!checkUserWithThiSNoExist()){
                    val user =  User(phone = register_username.text.toString()
                        ,password = register_password.text.toString())
                    userViewModel.register(user)
                    val intent = Intent(this,Login ::class.java)
                    startActivity(intent)

                }

            }
        }
    }

    fun validateInputs():Boolean{
        var isValid = true
        val username = register_username.text.toString()
        val password  = register_password.text.toString()
        val confirmPassword = register_confirm_password.text.toString()
        if(username.isNullOrEmpty() ){
            register_username_layout.setError("username cant be empty")
            isValid = false
        }
        if(password.isNullOrEmpty() ){
            register_password_layout.setError("password cant be empty")
            isValid = false
        }
        if(!password.equals(confirmPassword)){
            login_confirm_password_layout.setError("password and confirm password dont match")

            isValid = false
        }


        return isValid
    }

    fun checkUserWithThiSNoExist():Boolean{
        var Exist = false
        val username = register_username.text.toString()

        if( userViewModel.checkIfPhoneExist(username).value.toString().toInt() > 1){
            val snackbar = Snackbar.make(
                register_root_layout,
                "user with this number Exists.",
                Snackbar.LENGTH_LONG
            )
            // Get the snack bar root view
            val snack_root_view = snackbar.view
            snack_root_view.setBackgroundColor(Color.BLACK)
            snackbar.show()

            Exist = true
        }






        return Exist
    }


}
