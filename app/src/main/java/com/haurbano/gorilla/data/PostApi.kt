package com.haurbano.gorilla.data

import com.haurbano.gorilla.domain.models.Post
import io.reactivex.Single
import retrofit2.http.GET

interface PostApi {
    @GET("feed")
    fun getPost(): Single<List<Post>>
}