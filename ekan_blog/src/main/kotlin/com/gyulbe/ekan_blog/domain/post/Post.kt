package com.gyulbe.ekan_blog.domain.post

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Entity
@Table(name = "blog_post")
class Post(

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false, length = 200)
    var subTitle: String,

    @Column
    var content: String,

    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    private val updatedAt: LocalDateTime = LocalDateTime.now(),

    @Id
    @GeneratedValue
    val id: Long? = null,
)