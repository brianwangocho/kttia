package com.example.budgetia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener( View.OnClickListener {

            Login()
        })




    }

    fun Login(){

        val intent =  Intent(this,Dashboard::class.java)
        startActivity(intent)
    }
}
