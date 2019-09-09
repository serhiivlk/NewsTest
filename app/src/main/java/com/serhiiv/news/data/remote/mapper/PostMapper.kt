package com.serhiiv.news.data.remote.mapper

import com.serhiiv.news.data.remote.model.PostResponse
import com.serhiiv.news.domain.model.Post
import javax.inject.Inject

class PostMapper @Inject constructor() : BaseMapper<Post, PostResponse> {
    override fun map(from: PostResponse): Post = with(from) {
        Post(
            id = id ?: 0,
            userName = userName ?: "",
            userId = userId ?: "",
            userPic = userPic ?: "",
            message = message ?: "",
            photo = photo ?: "",
            date = date ?: ""
        )
    }
}