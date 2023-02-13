package com.gyulbe.ekan_blog.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@RestController
@RequestMapping("/auth")
class AuthController {

    @PostMapping("/ip")
    fun getUserIp(): String{
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes?)!!.request
        val ip = request.getHeader("X-FORWARDED-FOR")
        return ip
    }
}