package com.gyulbe.ekan_blog.service.post

import com.gyulbe.ekan_blog.domain.post.Post
import com.gyulbe.ekan_blog.requests.PostCreateRequest
import com.gyulbe.ekan_blog.responses.PostDeleteResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PostService{
    fun createPost(request: PostCreateRequest): Post
    fun getPosts(pageable: Pageable): Page<Post>
    fun getPostById(postId: Long): Post?
    fun deletePost(postId: Long)

}