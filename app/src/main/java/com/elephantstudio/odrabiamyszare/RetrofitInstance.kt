package com.elephantstudio.odrabiamyszare

import com.elephantstudio.odrabiamyszare.data.BooksApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: BooksApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://autobusy-ostrow.doteq.cf")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BooksApi::class.java)
    }
}