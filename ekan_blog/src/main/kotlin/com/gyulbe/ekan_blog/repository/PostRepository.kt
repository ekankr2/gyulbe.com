package com.gyulbe.ekan_blog.repository

import com.gyulbe.ekan_blog.domain.post.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
interface PostRepository : JpaRepository<Post, Long> {

}