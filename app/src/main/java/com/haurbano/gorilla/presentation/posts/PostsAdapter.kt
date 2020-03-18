package com.haurbano.gorilla.presentation.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.haurbano.gorilla.R
import com.haurbano.gorilla.domain.models.Post
import java.time.Instant
import java.time.format.DateTimeFormatter

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    var posts: List<Post> = emptyList()

    class ViewHolder(private val postView: View): RecyclerView.ViewHolder(postView) {
        val authorNameView = postView.findViewById<TextView>(R.id.authorName)
        val postDateView = postView.findViewById<TextView>(R.id.postDate)
        val postContentView = postView.findViewById<TextView>(R.id.postContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val postView = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(postView)
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.authorNameView.text = "${post.first_name} ${post.last_name}"
        val date = DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochSecond(post.unix_timestamp.toLong()))
        holder.postDateView.text = date
        holder.postContentView.text = post.post_body
    }
}