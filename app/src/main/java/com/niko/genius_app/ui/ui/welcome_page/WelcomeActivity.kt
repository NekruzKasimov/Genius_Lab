package com.niko.genius_app.ui.ui.welcome_page

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.niko.genius_app.R
import com.niko.genius_app.test.TestActivity
import com.niko.genius_app.ui.ui.main_menu.MainActivity
import kotlinx.android.synthetic.main.activity_werlcome.*

/**
 * Created by Ismet on 3/24/2018.
 */
class WelcomeActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_werlcome)
        nextButton.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}