package com.gyulbe.ekan_blog.domain.post

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "blog_post")
class Post(

    private val title: String,

    private val content: String,

    @Id
    @GeneratedValue
    private val id: Long
)
