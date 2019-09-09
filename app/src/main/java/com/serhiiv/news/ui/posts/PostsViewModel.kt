package com.serhiiv.news.ui.posts

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.serhiiv.news.data.repository.PostsRepository
import com.serhiiv.news.domain.model.Post
import javax.inject.Inject

class PostsViewModel @Inject constructor(
    private val postsRepository: PostsRepository
) : ViewModel() {

    private val mutableError = MutableLiveData<String>()

    val posts: LiveData<PagedList<Post>> = buildPostsPagedList()
    val error: LiveData<String>
        get() = mutableError

    init {

    }

    private fun buildPostsPagedList(): LiveData<PagedList<Post>> {
        val factory = PostsPagedDataSource.Factory(viewModelScope, postsRepository)
        val config = PagedList.Config.Builder()
            .setPageSize(50)
            .setPrefetchDistance(10)
            .setEnablePlaceholders(false)
            .build()
        return LivePagedListBuilder(factory, config).build()
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val viewModel: PostsViewModel
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return viewModel as T
        }
    }
}
