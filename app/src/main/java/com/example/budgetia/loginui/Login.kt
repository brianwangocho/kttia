package com.example.budgetia.loginui


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.budgetia.R
import com.example.budgetia.registerui.RegisterActivity
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
        userViewModel.loginRespnse.observe(this, Observer { it->
            Log.d(TAG,"login response is $it")

        })
//        todo find a way to remove erros after validation

        loginButton.setOnClickListener {
            if(validateInputs()){
          var c =  userViewModel.authenticateUser(login_username.text.toString(),login_password.text.toString()).value
             if(c == 0){
                 val snackbar = Snackbar.make(
                     login_layout,
                     "Invalid credentials.",
                     Snackbar.LENGTH_LONG
                 )
                 // Get the snack bar root view
                 val snack_root_view = snackbar.view
                 snack_root_view.setBackgroundColor(Color.BLACK)
                 snackbar.show()
             }

            }
        }

        //// go to register activity
        create_new_account.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

    }

    private  fun validateInputs():Boolean{
        var isValid = true
        val username = login_username.text.toString()
        val password  = login_password.text.toString()
        if(username.isNullOrEmpty() ){
            login_username_layout.setError("username cant be empty")
           isValid = false
        }
        if(password.isNullOrEmpty() ){
            login_password_layout.setError("password cant be empty")
            isValid = false
        }


        return isValid
    }


}
