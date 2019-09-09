package com.serhiiv.news.data.remote

import com.serhiiv.news.data.remote.model.PostsByPageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TestApiService {
    @GET("main/test")
    suspend fun getPostsByPage(@Query("page") page: Int): PostsByPageResponse
}