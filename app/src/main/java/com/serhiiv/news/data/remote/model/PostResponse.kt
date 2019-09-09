package com.serhiiv.news.data.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostResponse(
    @field:Json(name = "id")
    val id: Long? = null,
    @field:Json(name = "user_name")
    val userName: String? = null,
    @field:Json(name = "user_id")
    val userId: String? = null,
    @field:Json(name = "user_pic")
    val userPic: String? = null,
    @field:Json(name = "message")
    val message: String? = null,
    @field:Json(name = "photo")
    val photo: String? = null,
    @field:Json(name = "date")
    val date: String? = null
)