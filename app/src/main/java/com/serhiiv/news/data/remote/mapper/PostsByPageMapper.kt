package com.serhiiv.news.data.remote.mapper

import com.serhiiv.news.data.remote.model.PostsByPageResponse
import com.serhiiv.news.domain.model.PostsByPage
import javax.inject.Inject

class PostsByPageMapper @Inject constructor(
    private val postMapper: PostMapper
) : BaseMapper<PostsByPage, PostsByPageResponse> {
    override fun map(from: PostsByPageResponse): PostsByPage = with(from) {
        PostsByPage(
            totalPages = totalPages,
            page = page,
            posts = postMapper(posts)
        )
    }
}
