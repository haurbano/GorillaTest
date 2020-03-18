package com.haurbano.gorilla.domain.usecases

import com.haurbano.gorilla.domain.PostRepository
import com.haurbano.gorilla.domain.models.Post
import io.reactivex.Single

class GetPostsUseCaseImpl(
    private val postRepository: PostRepository
): GetPostsUseCase {
    override fun getPosts(): Single<List<Post>> {
        return postRepository.getPosts()
    }
}