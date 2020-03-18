package com.haurbano.gorilla.presentation.posts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.haurbano.gorilla.R
import com.haurbano.gorilla.common.timeStampToDisplayDate
import com.haurbano.gorilla.domain.models.Post
import java.time.Instant
import java.time.format.DateTimeFormatter

class PostsAdapter(
    private val context: Context
) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    private var data: ArrayList<Post> = arrayListOf()

    class ViewHolder(postView: View): RecyclerView.ViewHolder(postView) {
        val authorNameView: TextView = postView.findViewById(R.id.authorName)
        val postDateView: TextView = postView.findViewById(R.id.postDate)
        val postContentView: TextView = postView.findViewById(R.id.postContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val postView = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(postView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = data[position]
        holder.authorNameView.text = context.getString(R.string.full_name, post.first_name, post.last_name)
        holder.postDateView.text = post.unix_timestamp.timeStampToDisplayDate(context)
        holder.postContentView.text = post.post_body
    }

    fun update(posts: List<Post>) {
        data.clear()
        data.addAll(posts)
        notifyDataSetChanged()
    }

    fun addAtStart(post: Post) {
        data.add(0, post)
        notifyDataSetChanged()
    }
}