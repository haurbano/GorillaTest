package com.haurbano.gorilla.data

import com.haurbano.gorilla.domain.PostRepository
import com.haurbano.gorilla.domain.models.Post
import io.reactivex.Single

class PostRepositoryImpl(
    private val postApi: PostApi
): PostRepository {
    override fun getPosts(): Single<List<Post>> {
        return postApi.getPost()
    }
}