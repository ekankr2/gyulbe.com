package com.gyulbe.ekan_blog.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory

//@Configuration
//class RedisConfig {
//
//    @Value("\${spring.data.redis.port}")
//    private val port: Int = 6379
//
//    @Value("\${spring.data.redis.host}")
//    private val host: String = "localhost"
//
//    @Bean
//    fun redisConnectionFactory(): LettuceConnectionFactory {
//        return LettuceConnectionFactory(RedisStandaloneConfiguration(host, port))
//    }
//}