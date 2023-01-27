package com.gyulbe.ekan_blog.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ViewController {

    @GetMapping("/")
    fun indexPage(): String = "index"

    @GetMapping("/post/create")
    fun createPostPage(): String = "/post/create"
}