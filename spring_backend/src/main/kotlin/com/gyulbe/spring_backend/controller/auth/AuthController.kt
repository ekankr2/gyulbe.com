package com.gyulbe.spring_backend.controller.auth

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthControllers {

    @GetMapping("/hello")
    fun helloWorld(): String {
        return "worldsssss"
    }
}
