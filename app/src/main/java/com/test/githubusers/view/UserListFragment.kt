package com.test.githubusers.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment
import com.test.githubusers.R
import com.test.githubusers.activity.DetailActivity
import com.test.githubusers.module.UserItem
import com.test.githubusers.utils.MyUtilities


class UserListFragment : Fragment() {

    val TAG: String = javaClass.simpleName
    var mUserList: ArrayList<UserItem>? = null
    private var mGridView: GridView? = null
    private var mAdapter: UserListAdapter? = null

    companion object {
        fun newInstance(list: ArrayList<UserItem>?): UserListFragment {
            val fragment = UserListFragment()
            val args = Bundle()
            args.putSerializable("list", list)
            fragment.setArguments(args)
            return fragment
        }
    }

    

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.frag_user_list, container, false)
        if (this.arguments != null) {
            mUserList = this.arguments!!.getSerializable("list") as ArrayList<UserItem>?
            Log.d(TAG, "onCreateView, mUserList.size=" + mUserList?.size)
        }
        initViews(view)

        return view
    }

    private fun initViews(view: View) {
        val size = mUserList?.size ?: 0
        if (size > 0) {
            setupGridView(view)
        }

    }


    private fun setupGridView(view: View) {
        if (mUserList != null && context != null) {
            Log.d(TAG, "mUserList.size=" + mUserList!!.size)
            mAdapter = UserListAdapter(context!!, mUserList!!)
            mGridView = view.findViewById<GridView>(R.id.id_userlist_gridview)
            mGridView!!.numColumns = 1
            setDynamicHeight(mGridView!!, mUserList)
            mGridView!!.adapter = mAdapter!!
            mGridView!!.onItemClickListener =
                OnItemClickListener { parent, view, position, id ->
                    onItemClickAction(position)
                }
        }
    }

    private fun setDynamicHeight(gridView: GridView, list: ArrayList<UserItem>?) {
        if (context != null) {
            val size = calculateHeight(list)
            MyUtilities.setDynamicHeight(gridView, size, context!!)
        }
    }

    private fun calculateHeight(list: ArrayList<UserItem>?): Int {
        var size = 0
        if (list != null) {
            size = (list!!.size * 82) + 20
        }
        return size
    }

    private fun onItemClickAction(position: Int) {
        //Log.d(TAG, "onItemClickAction, position=" + position)
        if (mUserList != null) {
            val size = mUserList!!.size
            if (position >= 0 && position < size) {
                val item = mUserList!!.get(position)
                if (item != null) {
                    val url = item.get_url()
                    Log.d(TAG, "onItemClickAction, url=" + url)
                    if (!url.isNullOrEmpty()) {
                        activity?.let{
                            val intent = Intent (it, DetailActivity::class.java)
                            intent.putExtra("url", url)
                            it.startActivity(intent)
                        }
                    }
                }
            }
        }
    }

    fun updateUserList(list: ArrayList<UserItem>?) {
        Log.d(TAG, "updateUserList")
        mUserList = list
        val size = list?.size ?: 0
        if (context != null && view != null) {
            if (size > 0) {
                if (mGridView != null && mAdapter != null) {
                    mAdapter!!.updateUserList(list)
                    setDynamicHeight(mGridView!!, list)
                    mAdapter!!.notifyDataSetChanged()
                    mGridView!!.invalidateViews()
                    mGridView!!.smoothScrollToPosition(size - 1)
                }
                else {
                    setupGridView(view!!)
                }
            }
        }
    }





}