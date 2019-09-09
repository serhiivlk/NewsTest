package com.serhiiv.news.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostsByPageResponse(
    @field:Json(name = "total_pages")
    val totalPages: Int,
    @field:Json(name = "page")
    val page: Int,
    @field:Json(name = "posts")
    val posts: List<PostResponse>
)