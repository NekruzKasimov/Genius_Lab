package com.niko.genius_app.ui.ui.tips

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.niko.genius_app.R
import com.niko.genius_app.model.Tips
import kotlinx.android.synthetic.main.activity_tips_acitivity.*

class TipsAcitivity : AppCompatActivity(), TipsAdapter.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips_acitivity)

        init()
    }

    fun init() {
        resview_id.layoutManager = LinearLayoutManager(this)
        resview_id.adapter = TipsAdapter(ArrayList<Tips>(), this, this)
    }
    override fun onItemClick(tips: Tips) {
        /*val intent = Intent(this, DetailedTip::class.java)
        intent.putExtra("TIPS", tips)*/
    }

}
