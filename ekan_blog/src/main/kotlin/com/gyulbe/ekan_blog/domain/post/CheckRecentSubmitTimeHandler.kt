package com.gyulbe.ekan_blog.domain.post

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class CheckRecentSubmitTimeHandler {
    val recentRequests: ConcurrentHashMap<String, Map<String, Any>> = ConcurrentHashMap()
}