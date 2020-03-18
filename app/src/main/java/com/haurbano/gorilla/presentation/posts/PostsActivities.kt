package com.haurbano.gorilla.presentation.posts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.haurbano.gorilla.R
import com.haurbano.gorilla.domain.models.Post
import com.haurbano.gorilla.presentation.createpost.CreatePostActivity
import kotlinx.android.synthetic.main.activity_create_post.*
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class PostsActivities : AppCompatActivity() {

    private val viewModel: PostsViewModel by viewModel()
    private val postsAdapter: PostsAdapter = PostsAdapter()
    private var posts = arrayListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRV()
        bindPost()
        setupListeners()
        viewModel.fetchPosts()
    }

    private fun setupListeners() {
        txtWhatsMind.setOnClickListener {
            CreatePostActivity.navigate(this)
        }
    }

    private fun setupRV() {
        val layoutManager = LinearLayoutManager(this)
        rvPosts.apply {
            this.layoutManager = layoutManager
            this.adapter = postsAdapter
        }
    }

    private fun bindPost() {
        viewModel.posts.observe(this, Observer { posts ->
            this.posts.clear()
            this.posts.addAll(posts)
            updatePosts()
        })
    }

    private fun updatePosts() {
        postsAdapter.posts = posts
        postsAdapter.notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CreatePostActivity.CREATE_POST_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val postContent = data?.getStringExtra(CreatePostActivity.POST_CONTENT_KEY)
            addNewPost(postContent)
        }
    }

    private fun addNewPost(postContent: String?) {
        val unixTime = System.currentTimeMillis() / 1000L
        val newPost = Post(
            "Hamilton",
            123,
            "Urbano",
            postContent ?: "",
            unixTime.toString()
        )
        posts.add(0,newPost)
        updatePosts()
    }
}
