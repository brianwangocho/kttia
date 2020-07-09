package com.example.budgetia


import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.example.budgetia.loginui.Login
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT



        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity
            // Check if we're running on Android 5.0 or higher

            startActivity(Intent(this, Login::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)

    }
}