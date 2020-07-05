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
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        val detailIntent = Intent(this, Login::class.java)
        val imageViewPair = Pair.create<View, String>(app_splash, "logo_image")

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageViewPair)



        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity
            // Check if we're running on Android 5.0 or higher
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                // Apply activity transition
                startActivity(detailIntent,options.toBundle())
            } else {
                // Swap without transition
                startActivity(detailIntent)
            }
            startActivity(Intent(this,Login::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)

    }
}