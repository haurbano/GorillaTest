package com.haurbano.gorilla.di

import com.haurbano.gorilla.data.PostApi
import com.haurbano.gorilla.data.PostRepositoryImpl
import com.haurbano.gorilla.data.RetrofitClient
import com.haurbano.gorilla.domain.PostRepository
import com.haurbano.gorilla.domain.usecases.GetPostsUseCase
import com.haurbano.gorilla.domain.usecases.GetPostsUseCaseImpl
import com.haurbano.gorilla.presentation.posts.PostsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val postModule = module {
    single<PostApi> { RetrofitClient.get().create(PostApi::class.java) }

    factory<PostRepository> { PostRepositoryImpl(get()) }
    factory<GetPostsUseCase> { GetPostsUseCaseImpl(get()) }

    viewModel { PostsViewModel(get()) }
}