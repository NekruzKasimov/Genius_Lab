package com.niko.genius_app.test.adapter

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.RadioButton
import com.niko.genius_app.R
import com.niko.genius_app.test.TestActivity
import com.niko.genius_app.test.fragment.QuestionsFragment

/**
 * Created by Ismet on 3/24/2018.
 */
class ListViewAdapter(private var fragment: QuestionsFragment, private var models: ArrayList<String>, private var activity: FragmentActivity, private var pos: Int) : BaseAdapter() {

    private var selectedPosition = -1

    private class ViewHolder(row: View?) {
        var radioButton: RadioButton? = null

        init {
            this.radioButton = row?.findViewById<RadioButton>(R.id.radioButtonId)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = fragment.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.cell_list_view, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.radioButton!!.isChecked = position == selectedPosition
        viewHolder.radioButton!!.tag = position
        viewHolder.radioButton!!.text = models[position]
        viewHolder.radioButton!!.setOnClickListener { v -> itemCheckChanged(v) }

        return view as View
    }

    private fun itemCheckChanged(v: View) {
        selectedPosition = v.tag as Int
        notifyDataSetChanged()
        (activity as TestActivity).nextPage(pos)
    }

    override fun getItem(position: Int): Any = models[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = models.size

}