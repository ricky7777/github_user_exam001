package com.test.githubusers.module


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url
import java.util.*


interface ApiService {

        @GET("users")
        fun getUserList(): Call<ArrayList<UserItem>?>

        @GET
        fun getDetailItem(@Url url: String?): Call<DetailItem?>?

}