package com.serhiiv.news.data.repository

import com.serhiiv.news.data.remote.TestApiService
import com.serhiiv.news.data.remote.mapper.PostsByPageMapper
import com.serhiiv.news.domain.model.PostsByPage
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val testApiService: TestApiService,
    private val postsByPageMapper: PostsByPageMapper
) {
    suspend fun getPostsByPage(page: Int): PostsByPage {
        return testApiService.getPostsByPage(page)
            .let(postsByPageMapper::invoke)
    }
}
