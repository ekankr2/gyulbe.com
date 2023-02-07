package com.gyulbe.ekan_blog.service.post

import com.gyulbe.ekan_blog.domain.post.Post
import com.gyulbe.ekan_blog.repository.PostRepository
import com.gyulbe.ekan_blog.domain.post.PostRequest
import com.gyulbe.ekan_blog.utils.findByIdOrThrow
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(
    private val postRepository: PostRepository
) : PostService {

    @Transactional
    override fun createPost(request: PostRequest): Post = postRepository.save(request.toEntity())


    @Transactional
    override fun getPosts(pageable: Pageable): Page<Post> = postRepository.findAll(pageable)

    @Transactional
    override fun getPostById(postId: Long): Post? = postRepository.findByIdOrNull(postId)

    @Transactional
    override fun deletePost(postId: Long) {
        val maybePost = postRepository.findById(postId)
        if (maybePost.isPresent) return postRepository.delete(maybePost.get())
    }

    @Transactional
    override fun updatePost(request: PostRequest): Post {
        val post = postRepository.findByIdOrThrow(request.id)
        post.title = request.title
        post.subTitle = request.subTitle
        post.content = request.content
        return postRepository.save(post)
    }
}