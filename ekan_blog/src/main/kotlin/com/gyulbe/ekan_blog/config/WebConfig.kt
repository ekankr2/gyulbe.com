package com.gyulbe.ekan_blog.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://127.0.0.1:5173", "https://gyulbe.com")
            .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}