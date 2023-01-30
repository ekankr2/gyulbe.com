package com.gyulbe.ekan_blog.domain.post

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Entity
@Table(name = "blog_post")
class Post(

    @Id
    @GeneratedValue
    private val id: Long? = null,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false, length = 200)
    val subTitle: String,

    @Column
    val content: String,

    @CreatedDate
    private val createdAt: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    private val updatedAt: LocalDateTime = LocalDateTime.now(),
)