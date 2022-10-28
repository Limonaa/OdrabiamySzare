package com.elephantstudio.odrabiamyszare.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApi {

    @GET("/books")
    suspend fun getBooks(): Response<List<BookJSON>>
}