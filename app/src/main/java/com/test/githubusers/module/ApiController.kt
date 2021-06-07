package com.test.githubusers.module

import android.content.Context
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class ApiController {

    private val TAG = javaClass.simpleName
    val BaseUrl = "https://api.github.com/"

    companion object {
        private var mApiController: ApiController? = null

        fun getInstance(): ApiController {
            if(mApiController == null) {
                mApiController = ApiController()
            }
            return mApiController!!
        }
    }

    fun getUserList(context: Context? = null,
                    params: Objects?,
                    callBack: Callback<ArrayList<UserItem>?>): Call<ArrayList<UserItem>?>? {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        if (retrofit != null) {
            val apiService = retrofit.create(ApiService::class.java)
            val call = apiService.getUserList()
            if (call != null) {
                call.enqueue(callBack)
                return call
            }
        }
        return null
    }

    fun getDetailItem(context: Context? = null,
                      url: String,
                      callBack: Callback<DetailItem?>): Call<DetailItem?>? {
        //Log.d(TAG, "getDetailItem, url=" + url)
        if (!url.isNullOrEmpty()) {
            var myUrl = ""
            if (url.startsWith(BaseUrl)) {
                myUrl = url.substring(BaseUrl.length)
            }
            val retrofit = Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            if (retrofit != null) {
                val apiService = retrofit.create(ApiService::class.java)
                val call = apiService.getDetailItem(myUrl)
                if (call != null) {
                    call.enqueue(callBack)
                    return call
                }
            }
        }
        return null
    }





}