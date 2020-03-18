package com.haurbano.gorilla.domain.models

data class Post(
    val first_name: String,
    val id: Int,
    val last_name: String,
    val post_body: String,
    val unix_timestamp: String
)