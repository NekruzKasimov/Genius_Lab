package com.niko.genius_app.test.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import java.util.ArrayList

/**
 * Created by Ismet on 3/23/2018.
 */
class SectionPagerAdapter(fragment: FragmentManager) : FragmentStatePagerAdapter(fragment) {
    private var listOfFragments: ArrayList<Fragment>? = ArrayList()

    fun addFragments(frag: Fragment, title: String) {
        listOfFragments!!.add(frag)
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment? {
        return if (listOfFragments == null) null else listOfFragments!![position]
    }

    override fun getCount(): Int {
        return listOfFragments!!.size
    }

    fun clear() {
        listOfFragments = ArrayList()
        notifyDataSetChanged()
    }
}