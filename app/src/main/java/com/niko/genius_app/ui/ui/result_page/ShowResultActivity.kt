package com.niko.genius_app.ui.ui.result_page

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.niko.genius_app.R
import com.niko.genius_app.ui.ui.consultation.Consultation
import com.niko.genius_app.ui.ui.main_menu.MainActivity
import kotlinx.android.synthetic.main.activity_show_result.*
import kotlinx.android.synthetic.main.toolbar.*

class ShowResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_result)
        title = "Результат"
        initToolbar()

        help_Button.setOnClickListener {
            var intent = Intent(this, Consultation::class.java)
            startActivity(intent)
            finish()
        }

        goToTestButton.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}
