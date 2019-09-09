package com.serhiiv.news.ui.posts

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.serhiiv.news.data.repository.PostsRepository
import com.serhiiv.news.domain.model.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PostsPagedDataSource constructor(
    scope: CoroutineScope,
    private val postsRepository: PostsRepository
) : PageKeyedDataSource<Int, Post>(), CoroutineScope by scope {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Post>
    ) {
        launch {
            val (totalPages, page, posts) = postsRepository.getPostsByPage(1)
            val nextPage = if (page < totalPages) page + 1 else null
            callback.onResult(posts, null, nextPage)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Post>) {
        launch {
            val (totalPages, page, posts) = postsRepository.getPostsByPage(params.key)
            val nextPage = if (page < totalPages) page + 1 else null
            callback.onResult(posts, nextPage)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Post>) {
        launch {
            val (totalPages, page, posts) = postsRepository.getPostsByPage(params.key)
            val prevPage = if (page > 1) page - 1 else null
            callback.onResult(posts, prevPage)
        }
    }

    class Factory constructor(
        private val scope: CoroutineScope,
        private val postsRepository: PostsRepository
    ) : DataSource.Factory<Int, Post>() {
        override fun create(): DataSource<Int, Post> {
            return PostsPagedDataSource(scope, postsRepository)
        }
    }
}
