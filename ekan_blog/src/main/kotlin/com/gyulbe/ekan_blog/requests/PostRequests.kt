package com.gyulbe.ekan_blog.requests

data class PostCreateRequest(
    val title: String,
    val subTitle: String,
    val content: String,
)