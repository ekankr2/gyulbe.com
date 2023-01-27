package com.gyulbe.ekan_blog.controller

import com.gyulbe.ekan_blog.domain.post.Post
import com.gyulbe.ekan_blog.requests.post.PostCreateRequest
import com.gyulbe.ekan_blog.service.post.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController(
    private val postService: PostService
) {

    @PostMapping("")
    fun createPost(@RequestBody request: PostCreateRequest): Post {
        return postService.createPost(request)
    }

    @GetMapping("")
    fun getPost(): String {
        return "ok"
    }
}