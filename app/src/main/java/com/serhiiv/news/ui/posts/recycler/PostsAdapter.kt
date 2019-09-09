package com.serhiiv.news.ui.posts.recycler

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.serhiiv.news.R
import com.serhiiv.news.domain.model.Post
import com.serhiiv.news.extention.inflate
import kotlinx.android.synthetic.main.list_item_post.view.*

class PostsAdapter : PagedListAdapter<Post, PostsAdapter.PostViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(parent.inflate(R.layout.list_item_post))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = getItem(position)
        item?.let(holder::bind)
    }


    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post) = with(itemView) {
            user_avatar.load(post.userPic) {
                transformations(CircleCropTransformation())
            }
            user_name.text = post.userName
            post_date.text = post.date
            message.text = post.message
            if (post.photo.isNotEmpty()) {
                photo.visibility = View.VISIBLE
                photo.load(post.photo)
            } else {
                photo.visibility = View.GONE
            }
        }
    }

    companion object {
        @JvmStatic
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem == newItem
            }
        }
    }
}
