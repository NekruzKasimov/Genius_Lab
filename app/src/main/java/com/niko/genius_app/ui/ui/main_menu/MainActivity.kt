package com.niko.genius_app.ui.ui.main_menu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.niko.genius_app.R
import com.niko.genius_app.model.Model
import com.niko.genius_app.test.TestActivity
import com.niko.genius_app.ui.ui.tips.TipsAcitivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var data: ArrayList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        test_id.setOnClickListener {
            init(1)
            var intent = Intent(this, TestActivity::class.java)
            intent.putExtra("Data", data)
            startActivity(intent)
        }

        tips_id.setOnClickListener {
            init(2)
            var intent = Intent(this, TestActivity::class.java)
            intent.putExtra("Data", data)
            startActivity(intent)
        }

    }

    fun init(i: Int) {
        if (i == 1) {

            val text = resources.openRawResource(R.raw.data)
                    .bufferedReader().use { it.readText() }
            data = getExpenses(text)
        } else {
            val text = resources.openRawResource(R.raw.test2)
                    .bufferedReader().use { it.readText() }
            data = getExpenses(text)
        }

    }

    fun getExpenses(jsonStr: String): ArrayList<Model> {
        return Gson().fromJson<ArrayList<Model>>(jsonStr, object : TypeToken<ArrayList<Model>>() {

        }.type)
    }
}
