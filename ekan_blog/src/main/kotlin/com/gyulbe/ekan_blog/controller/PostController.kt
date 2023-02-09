package com.gyulbe.ekan_blog.controller

import com.gyulbe.ekan_blog.domain.post.Post
import com.gyulbe.ekan_blog.domain.post.PostRequest
import com.gyulbe.ekan_blog.service.post.PostServiceImpl
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/posts")
class PostController(
    private val postServiceImpl: PostServiceImpl
) {

    @PostMapping("")
    fun createPost(@RequestBody request: PostRequest): Post {
        return postServiceImpl.createPost(request)
    }

    @GetMapping("")
    fun getAllPosts(@PageableDefault(page = 0, size = 20, sort = ["id"]) pageable: Pageable): Page<Post> {
        return postServiceImpl.getPosts(pageable)
    }

    @GetMapping("/{id}")
    fun getPost(@PathVariable id: String): ResponseEntity<Any> {
        val postOrNull = postServiceImpl.getPostByIdOrNull(id.toLong())

        if(postOrNull != null) return ResponseEntity(postOrNull, HttpStatus.OK)
        throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @PutMapping("")
    fun updatePost(@RequestBody request: PostRequest): Post {
        return postServiceImpl.updatePost(request)
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: String) {
        return postServiceImpl.deletePost(id.toLong())
    }
}