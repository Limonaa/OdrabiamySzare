package com.elephantstudio.odrabiamyszare.data

data class Book(
    val id: Int,
    val subject: String,
    val title: String,
    val type: String
): java.io.Serializable