package com.haurbano.gorilla.presentation.posts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.haurbano.gorilla.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class PostsActivities : AppCompatActivity() {

    private val viewModel: PostsViewModel by viewModel()
    private val postsAdapter: PostsAdapter = PostsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRV()
        bindPost()
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchPosts()
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
            postsAdapter.posts = posts
            postsAdapter.notifyDataSetChanged()
        })
    }
}
