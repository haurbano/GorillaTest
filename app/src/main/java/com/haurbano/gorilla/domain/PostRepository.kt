package com.haurbano.gorilla.domain

import com.haurbano.gorilla.domain.models.Post
import io.reactivex.Single

interface PostRepository {
    fun getPosts(): Single<List<Post>>
}