package com.test.githubusers.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.test.githubusers.R
import com.test.githubusers.module.DetailItem


enum class DetailCellType {
    LOGIN, LOCATION, BLOG
}

// 這是DetailActivity下方三行的畫面
// 由於畫面類似，可以歸類在一起
// 不同處以 DetailCellType 做區隔
class DetailCell : Fragment() {

    private val TAG: String = DetailCell::class.java.simpleName
    private var mType = DetailCellType.LOGIN
    private var mDetailItem: DetailItem? = null


    companion object {

        fun newInstance(type: DetailCellType, detailItem: DetailItem): DetailCell {
            val fragment = DetailCell()
            val args = Bundle()
            args.putSerializable("type", type)
            args.putSerializable("detailItem", detailItem)
            fragment.setArguments(args)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (this.arguments != null) {
            mType = this.arguments!!.getSerializable("type") as DetailCellType
            mDetailItem = this.arguments!!.getSerializable("detailItem") as DetailItem
        }
        val view: View = inflater.inflate(R.layout.frag_detail_cell, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        setupImageView(view)
        setupUserTextView(view)
    }

    private fun setupImageView(view: View) {
        if (context != null) {
            val imageView = view.findViewById<ImageView>(R.id.id_dc_imageview)
            if (mType == DetailCellType.LOGIN) {
                imageView.setImageDrawable(context!!.getResources().getDrawable(R.drawable.icon_user))
            }
            else if (mType == DetailCellType.LOCATION) {
                imageView.setImageDrawable(context!!.getResources().getDrawable(R.drawable.icon_location))
            }
            else if (mType == DetailCellType.BLOG) {
                imageView.setImageDrawable(context!!.getResources().getDrawable(R.drawable.icon_blog))
            }
        }
    }

    private fun setupUserTextView(view: View) {
        if (context != null && mDetailItem != null) {
            val site_admin = mDetailItem!!.get_site_admin()
            var text = ""
            if (mType == DetailCellType.LOGIN) {
                text = mDetailItem!!.get_login()
            }
            else if (mType == DetailCellType.LOCATION) {
                text = mDetailItem!!.get_location()
            }
            else if (mType == DetailCellType.BLOG) {
                text = mDetailItem!!.get_blog()
            }
            val textView1 = view.findViewById<TextView>(R.id.id_dc_textview1)
            val infoLayout = view.findViewById<LinearLayout>(R.id.id_dc_info_layout)
            if (site_admin && mType == DetailCellType.LOGIN) {
                textView1.visibility = View.GONE
                infoLayout.visibility = View.VISIBLE
                val textView2 = view.findViewById<TextView>(R.id.id_dc_textview2)
                textView2.text = text
            }
            else {
                textView1.visibility = View.VISIBLE
                infoLayout.visibility = View.GONE
                textView1.text = text
                if (mType == DetailCellType.BLOG) {
                    textView1.setTextColor((context!!.getResources().getColor(R.color.blue)))
                    textView1.isClickable = true
                    setupButton(view, textView1, text)
                }
            }
        }

    }

    private fun setupButton(view: View, button: TextView, urlString: String) {
        button.setOnClickListener { view ->
            if (!urlString.isNullOrEmpty() && urlString.startsWith("http")) {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(urlString))
                startActivity(browserIntent)
            }
        }
    }




}