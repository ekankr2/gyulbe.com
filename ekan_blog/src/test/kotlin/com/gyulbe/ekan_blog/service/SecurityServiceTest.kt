package com.gyulbe.ekan_blog.service

import com.gyulbe.ekan_blog.annotation.CheckRecentSubmitTime
import org.junit.jupiter.api.Test

class SecurityServiceTest {

    @Test
    @CheckRecentSubmitTime
    fun checkApiSubmitTime() {
        println("okok")
    }
}