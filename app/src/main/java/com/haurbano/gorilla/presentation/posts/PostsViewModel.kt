package com.haurbano.gorilla.presentation.posts

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.haurbano.gorilla.domain.models.Post
import com.haurbano.gorilla.domain.usecases.GetPostsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PostsViewModel(
    private val getPostsUseCase: GetPostsUseCase
): ViewModel() {
    val posts: MutableLiveData<List<Post>> by lazy { MutableLiveData<List<Post>>() }

    private val disposables = CompositeDisposable()

    fun fetchPosts() {
        val disposable = getPostsUseCase.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { postsResult -> posts.value = postsResult },
                {error -> Log.e("Error Posts", error.localizedMessage)}
        )

        disposables.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}