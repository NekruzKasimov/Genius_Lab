package com.niko.genius_app.ui.ui.tips

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niko.genius_app.R
import com.niko.genius_app.model.Tips
import kotlinx.android.synthetic.main.cell_tips.view.*


class TipsAdapter(private val list: ArrayList<Tips>,
                  private val context: Context, private val listener: OnItemClickListener)
    : RecyclerView.Adapter<TipsAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.cell_tips, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindItem(list[position])
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(tips: Tips) {

            itemView.title_id.text = tips.title
            itemView.body_id.text = tips.body
            itemView!!.setOnClickListener{
                listener.onItemClick(list[position])
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(tips: Tips)
    }
}