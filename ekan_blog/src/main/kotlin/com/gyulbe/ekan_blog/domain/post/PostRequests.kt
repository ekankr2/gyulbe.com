package com.gyulbe.ekan_blog.domain.post

data class PostRequest(
    val title: String,
    val subTitle: String,
    val content: String,
    val id: Long? = null
) {
    fun toEntity(): Post = Post(
        title = title,
        subTitle = subTitle,
        content = content
    )
}

data class RequestAttributes(
    val requestUrl: String,
    val method: String
)