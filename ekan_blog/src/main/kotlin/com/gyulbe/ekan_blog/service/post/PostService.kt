package com.gyulbe.ekan_blog.service.post

import com.gyulbe.ekan_blog.domain.post.Post
import com.gyulbe.ekan_blog.repository.PostRepository
import com.gyulbe.ekan_blog.requests.post.PostCreateRequest
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {

    @Transactional
    fun createPost(request: PostCreateRequest): Post {
        val newPost = Post(title = request.title, subTitle = request.subTitle, content = request.content)
        return postRepository.save(newPost)
    }

    @Transactional
    fun getPosts(pageable: Pageable): Page<Post> {
        return postRepository.findAll(pageable)
    }
}