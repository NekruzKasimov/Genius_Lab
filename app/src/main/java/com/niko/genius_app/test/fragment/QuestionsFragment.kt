package com.niko.genius_app.test.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.niko.genius_app.utils.GlideImageTarget
import com.niko.genius_app.R
import com.niko.genius_app.model.Model
import com.niko.genius_app.test.adapter.ListViewAdapter
import com.niko.genius_app.utils.Constants.Companion.ANSWERS
import kotlinx.android.synthetic.main.fragment_questions.*

class QuestionsFragment : Fragment() {

    lateinit var model: Model
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_questions,
        container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        model = arguments.getParcelable("data")
        var pos = arguments.getInt("position")

        text_id.text = model.question
            Glide.with(activity)
                    .load(model.url)
                    .asBitmap()
                    .dontAnimate()
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(GlideImageTarget(pic_id))

        list_id.adapter = ListViewAdapter(this, ANSWERS, activity, pos)
        list_id.isExpanded = true
        list_id.isFocusable = false
    }
}
