package com.haurbano.gorilla.presentation.createpost

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.haurbano.gorilla.R
import kotlinx.android.synthetic.main.activity_create_post.*


class CreatePostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.create_post_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.create_post_menu_item -> addPost()
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun addPost() {
        if (editPostContent.text.isEmpty()) {
            Toast.makeText(this, "Post content empty", Toast.LENGTH_SHORT).show()
            return
        }

        val data = Intent()
        val postContent = editPostContent.text.toString()
        data.putExtra(POST_CONTENT_KEY, postContent)
        setResult(RESULT_OK, data)
        finish()
    }

    companion object {
        const val CREATE_POST_REQUEST_CODE = 10101
        const val POST_CONTENT_KEY = "post content"

        fun navigate(context: Activity) {
            val intent = Intent(context, CreatePostActivity::class.java)
            context.startActivityForResult(intent, CREATE_POST_REQUEST_CODE)
        }
    }
}
