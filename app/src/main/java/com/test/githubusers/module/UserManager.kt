package com.test.githubusers.module

import android.util.Log
import java.util.ArrayList


class UserManager {

    companion object {
        private val TAG = javaClass.simpleName
        private val MAX_USERS = 100
        private var mUserManager: UserManager? = null
        private var mUserList: ArrayList<UserItem>? = null

        fun getInstance(): UserManager {
            if(mUserManager ==null) {
                mUserManager = UserManager()
            }
            return mUserManager!!
        }
    }

    fun getUserList(): ArrayList<UserItem>? {
        return mUserList;
    }

    fun setUserList(userList: ArrayList<UserItem>?) {
        mUserList = userList
        if (mUserList != null) {
            val size = mUserList!!.size
            if (size > MAX_USERS) {
                mUserList!!.subList(MAX_USERS, size).clear();
            }
        }
    }



}
