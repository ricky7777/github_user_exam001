package com.test.githubusers.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.test.githubusers.R
import com.test.githubusers.module.ApiController
import com.test.githubusers.module.DetailItem
import com.test.githubusers.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailActivity : AppCompatActivity(), TitleBarFragListener {
    private val TAG = javaClass.simpleName
    private var mContext: Context? = null
    private lateinit var mProgressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        mContext = this
        val url = intent.getStringExtra("url").toString()
        setupProgressBar()
        getDetailItem(url)
    }

    private fun setupUI(detailItem: DetailItem) {
        setupTitleBar()
        setupAvatar(detailItem)
        setupNameTextView(detailItem)
        setupBioTextView(detailItem)
        setupDetailCell1(detailItem)
        setupDetailCell2(detailItem)
        setupDetailCell3(detailItem)
    }

    private fun setupTitleBar() {
        val titleBarFragment = TitleBarFragment.newInstance("", TitleLeftType.CLOSE, this)
        supportFragmentManager.beginTransaction().add(R.id.id_dt_title_bar, titleBarFragment).commit()
    }

    private fun setupAvatar(detailItem: DetailItem) {
        val avatar_url = detailItem.get_avatar_url()
        if (!avatar_url.isNullOrEmpty() && mContext != null) {
            val imageView = findViewById<ImageView>(R.id.id_dt_avatar)
            Glide.with(mContext!!)
                .setDefaultRequestOptions(
                    RequestOptions().fitCenter().format(DecodeFormat.PREFER_RGB_565).circleCrop()
                )
                .load(avatar_url)
                .into(imageView)
        }
    }

    private fun setupNameTextView(detailItem: DetailItem) {
        val name = detailItem.get_name()
        val textView = findViewById<TextView>(R.id.id_dt_name_tv)
        textView.text = name
    }

    private fun setupBioTextView(detailItem: DetailItem) {
        val bio = detailItem.get_bio()
        val textView = findViewById<TextView>(R.id.id_dt_bio_tv)
        textView.text = bio
    }

    private fun setupDetailCell1(detailItem: DetailItem) {
        val cell1 = DetailCell.newInstance(DetailCellType.LOGIN, detailItem)
        supportFragmentManager.beginTransaction().add(R.id.id_dt_cell1, cell1).commit()
    }

    private fun setupDetailCell2(detailItem: DetailItem) {
        val cell2 = DetailCell.newInstance(DetailCellType.LOCATION, detailItem)
        supportFragmentManager.beginTransaction().add(R.id.id_dt_cell2, cell2).commit()
    }

    private fun setupDetailCell3(detailItem: DetailItem) {
        val cell3 = DetailCell.newInstance(DetailCellType.BLOG, detailItem)
        supportFragmentManager.beginTransaction().add(R.id.id_dt_cell3, cell3).commit()
    }

    private fun setupProgressBar() {
        mProgressBar = findViewById(R.id.id_dt_progress_bar)
    }

    private fun getDetailItem(url: String?) {
        //Log.d(TAG, "getDetailItem, url=" + url)
        if (url != null && !url!!.isNullOrEmpty()) {
            mProgressBar.visibility = View.VISIBLE
            ApiController.getInstance().getDetailItem(mContext, url, object : Callback<DetailItem?> {
                override fun onResponse(call: Call<DetailItem?>?, response: Response<DetailItem?>) {
                    mProgressBar.visibility = View.GONE
                    if (response.isSuccessful()) {
                        val status = response.code()
                        if (status == 200) {
                            val detailItem = response.body()
                            if (detailItem != null) {
//                                val jsonString = Gson().toJson(detailItem!!)
//                                Log.d(TAG, "jsonString=" + jsonString)
                                setupUI(detailItem)
                            }
                        }
                        else if (status == 304) {
                            Log.e(TAG, "Status: 304 Not Modified")
                        }
                        else if (status == 401) {
                            Log.e(TAG, "Status: 401 Unauthorized")
                        }
                        else if (status == 403) {
                            Log.e(TAG, "Status: 403 Forbidden")
                        }
                    }
                }

                override fun onFailure(call: Call<DetailItem?>?, t: Throwable) {
                    Log.e(TAG, "onFailure : " + t.message)
                    mProgressBar.visibility = View.GONE
                }
            })
        }

    }

    override fun titleBarBackAction() {
        Log.d(TAG, "titleBarBackAction")
        finish()
    }

    override fun titleBarRightAction() {

    }
}