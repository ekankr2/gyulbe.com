package com.gyulbe.ekan_blog.controller

import com.gyulbe.ekan_blog.domain.post.Post
import com.gyulbe.ekan_blog.requests.post.PostCreateRequest
import com.gyulbe.ekan_blog.service.post.PostServiceImpl
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/posts")
class PostController(
    private val postServiceImpl: PostServiceImpl
) {

    @PostMapping("")
    fun createPost(@RequestBody request: PostCreateRequest): Post {
        return postServiceImpl.createPost(request)
    }

    @GetMapping("")
    fun getAllPosts(@PageableDefault(page = 0, size = 20, sort = ["id"]) pageable: Pageable): Page<Post> {
        return postServiceImpl.getPosts(pageable)
    }

    @GetMapping("/{id}")
    fun getPost(@PathVariable id: String): Post? {
        return postServiceImpl.getPostById(id.toLong())
    }
}