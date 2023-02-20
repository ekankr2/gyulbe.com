package com.gyulbe.ekan_blog.domain.post

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalTime
import java.util.concurrent.ConcurrentHashMap

@Component
class RecentRequestHandler{
    val recentRequests: ConcurrentHashMap<String, Map<String, Any>> = ConcurrentHashMap()
    fun handleRecentRequestInfo(requestContext: HttpServletRequest): Map<String, Any>? {
        val clientIp = requestContext.remoteAddr
        var count = 0
        val now = LocalTime.now()

        if (recentRequests[clientIp]?.get("count") != null) {
            count = recentRequests[clientIp]?.get("count") as Int + 1
        }

        val requestOptions = mapOf<String, Any>(
            "lastRequestedAt" to now,
            "requestUrl" to requestContext.requestURL,
            "method" to requestContext.method,
            "count" to count
        )

        recentRequests[clientIp] = requestOptions
        println(recentRequests[clientIp])
        return recentRequests[clientIp]
    }
}