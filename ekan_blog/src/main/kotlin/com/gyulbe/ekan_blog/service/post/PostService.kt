package com.gyulbe.ekan_blog.service.post

import com.gyulbe.ekan_blog.domain.post.Post
import com.gyulbe.ekan_blog.domain.post.PostRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PostService{
    fun createPost(request: PostRequest): Post
    fun getPosts(pageable: Pageable): Page<Post>
    fun getPostByIdOrNull(postId: Long): Post?
    fun deletePost(postId: Long)
    fun updatePost(request: PostRequest): Post

}