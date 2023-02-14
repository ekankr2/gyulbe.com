package com.gyulbe.ekan_blog.service

import com.gyulbe.ekan_blog.aspect.CheckLastSubmitTime
import org.junit.jupiter.api.Test

class SecurityServiceTest {

    @Test
    @CheckLastSubmitTime
    fun checkApiSubmitTime() {
        println("okok")
    }
}