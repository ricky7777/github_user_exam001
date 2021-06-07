package com.test.githubusers.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.test.githubusers.R
import com.test.githubusers.module.UserItem


class UserListAdapter(context: Context, list: ArrayList<UserItem>?) : BaseAdapter() {

    private val TAG: String = javaClass.simpleName
    internal var mUserList: ArrayList<UserItem>? = null
    private val mInflator: LayoutInflater
    private var mContext: Context? = null

    init {
        this.mInflator = LayoutInflater.from(context)
        this.mUserList = list
        this.mContext = context
    }

    override fun getCount(): Int {
        if (mUserList != null) {
            return mUserList!!.size
        }
        return 0
    }

    override fun getItem(position: Int): UserItem {
        return mUserList!!.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val grid: View?
        if (convertView == null) {
            grid = this.mInflator.inflate(R.layout.frag_user_item, parent, false)
        } else {
            grid = convertView
        }
        val userItem: UserItem = getItem(position)
        if (userItem != null) {
            setupAvatar(grid!!, position, userItem!!)
            setupUserTextView(grid!!, position, userItem!!)
        }
        return grid
    }



    private fun setupAvatar(grid: View, position: Int, userItem: UserItem) {
        val avatar_url = userItem.get_avatar_url()
        if (!avatar_url.isNullOrEmpty() && mContext != null) {
            val imageView = grid!!.findViewById<ImageView>(R.id.id_user_avatar)
            Glide.with(mContext!!)
                .setDefaultRequestOptions(
                    RequestOptions().fitCenter().format(DecodeFormat.PREFER_RGB_565).circleCrop()
                )
                .load(avatar_url)
                .into(imageView)
        }
    }

    private fun setupUserTextView(grid: View, position: Int, userItem: UserItem) {
        val site_admin = userItem.get_site_admin()
        val login = userItem.get_login()
        val userTV1 = grid!!.findViewById<TextView>(R.id.id_user_login_tv1)
        val infoLayout = grid!!.findViewById<LinearLayout>(R.id.id_user_info_layout)
        if (site_admin) {
            userTV1.visibility = View.GONE
            infoLayout.visibility = View.VISIBLE
            val userTV2 = grid!!.findViewById<TextView>(R.id.id_user_login_tv2)
            userTV2.text = login
        }
        else {
            userTV1.visibility = View.VISIBLE
            infoLayout.visibility = View.GONE
            userTV1.text = login
        }
    }






    fun updateUserList(list: ArrayList<UserItem>?) {
        if (list != null) {
            mUserList = list
        }
    }



}