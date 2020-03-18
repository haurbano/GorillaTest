package com.haurbano.gorilla.domain.usecases

import com.haurbano.gorilla.domain.models.Post
import io.reactivex.Single

interface GetPostsUseCase {
    fun getPosts(): Single<List<Post>>
}