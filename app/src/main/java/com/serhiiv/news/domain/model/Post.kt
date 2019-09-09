package com.serhiiv.news.domain.model

data class Post(
    val id: Long,
    val userName: String,
    val userId: String,
    val userPic: String,
    val message: String,
    val photo: String,
    val date: String
)
