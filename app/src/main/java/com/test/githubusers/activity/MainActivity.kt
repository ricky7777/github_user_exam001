package com.test.githubusers.activity

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.test.githubusers.R
import com.test.githubusers.module.ApiController
import com.test.githubusers.module.UserItem
import com.test.githubusers.module.UserManager
import com.test.githubusers.view.UserListFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName
    private var mContext: Context? = null
    private lateinit var mProgressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this
        setupProgressBar()
        getUserList()
    }

    private fun setupUserListFragment(userList: ArrayList<UserItem>?) {
        val userListFragment = UserListFragment.newInstance(userList)
        supportFragmentManager.beginTransaction().add(R.id.id_userlist_layout, userListFragment).commit()
    }

    private fun setupProgressBar() {
        mProgressBar = findViewById(R.id.id_progress_bar)

    }

    private fun getUserList() {
        mProgressBar.visibility = View.VISIBLE
        ApiController.getInstance().getUserList(mContext, null, object : Callback<ArrayList<UserItem>?> {
            override fun onResponse(call: Call<ArrayList<UserItem>?>?, response: Response<ArrayList<UserItem>?>) {
                mProgressBar.visibility = View.GONE
                if (response.isSuccessful()) {
                    val status = response.code()
                    if (status == 200) {
                        val userList = response.body()
                        if (userList != null) {
                            UserManager.getInstance().setUserList(userList)
                            val jsonString = Gson().toJson(userList!!)
                            Log.d(TAG, "jsonString=" + jsonString)
                            setupUserListFragment(userList)
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

            override fun onFailure(call: Call<ArrayList<UserItem>?>?, t: Throwable) {
                Log.e(TAG, "onFailure : " + t.message)
                mProgressBar.visibility = View.GONE
            }
        })
    }
}