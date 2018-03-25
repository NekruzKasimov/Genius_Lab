package com.niko.genius_app.test

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.niko.genius_app.R
import com.niko.genius_app.model.Model
import com.niko.genius_app.test.adapter.SectionPagerAdapter
import com.niko.genius_app.test.fragment.QuestionsFragment
import com.niko.genius_app.ui.ui.result_page.ShowResultActivity
import kotlinx.android.synthetic.main.activity_test.*


class TestActivity : AppCompatActivity() {
    var adapterViewPager: SectionPagerAdapter? = null

    lateinit var data: ArrayList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        init()
    }


    private fun init() {
        //val text = resources.openRawResource(R.raw.data)
      //          .bufferedReader().use { it.readText() }
      //  data = getExpenses(text)

        data = intent.getParcelableArrayListExtra("Data")

        val adapter = SectionPagerAdapter(supportFragmentManager)

        for (x in data) {
            val fragment = QuestionsFragment()
            val bundle = Bundle()
            bundle.putParcelable("data", x)
            bundle.putInt("position", data.indexOf(x))
            fragment.arguments = bundle
            adapter.addFragments(fragment, "f")
        }



        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = data.size
    }

    fun nextPage(pos: Int){
        if (pos + 1 == data.size) {
            var intent = Intent(this, ShowResultActivity::class.java)
            startActivity(intent)
            finish()
        }
     //   viewPager.setScrollDurationFactor(5.0)
//        viewPager.setCurrentItem(pos + 1, true)
    }
}
