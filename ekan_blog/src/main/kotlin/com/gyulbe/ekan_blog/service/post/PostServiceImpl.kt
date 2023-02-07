package com.gyulbe.ekan_blog.service.post

import com.gyulbe.ekan_blog.domain.post.Post
import com.gyulbe.ekan_blog.repository.PostRepository
import com.gyulbe.ekan_blog.requests.PostCreateRequest
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
    override fun createPost(request: PostCreateRequest): Post {
        val newPost = Post(title = request.title, subTitle = request.subTitle, content = request.content)
        return postRepository.save(newPost)
    }

    @Transactional
    override fun getPosts(pageable: Pageable): Page<Post> {
        return postRepository.findAll(pageable)
    }

    @Transactional
    override fun getPostById(postId: Long): Post? {
        return postRepository.findByIdOrNull(postId)
    }

    @Transactional
    override fun deletePost(postId: Long) {
        val maybePost = postRepository.findById(postId)
        if(maybePost.isPresent) return postRepository.delete(maybePost.get())
    }
}