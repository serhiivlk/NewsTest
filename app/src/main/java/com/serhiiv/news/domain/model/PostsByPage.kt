package com.serhiiv.news.domain.model

data class PostsByPage(
    val totalPages: Int,
    val page: Int,
    val posts: List<Post>
)
