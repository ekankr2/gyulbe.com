package com.gyulbe.ekan_blog.domain.post

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Component
import java.time.LocalTime
import java.util.concurrent.ConcurrentHashMap

@Component
class RecentRequestHandler {
    val recentRequests: ConcurrentHashMap<String, Map<String, Any>> = ConcurrentHashMap()
    fun handleRecentRequestInfo(requestContext: HttpServletRequest): Map<String, Any>? {
        val clientIp = requestContext.remoteAddr
        val lastRequestedAt = recentRequests[clientIp]?.get("lastRequestedAt") as? LocalTime
        var count = 0

        if (lastRequestedAt != null && isAfterLastRequestedAt(lastRequestedAt, 5)) {
            count = recentRequests[clientIp]?.get("count") as Int + 1
        }

        val requestOptions = mapOf<String, Any>(
            "lastRequestedAt" to LocalTime.now(),
            "requestUrl" to requestContext.requestURL,
            "method" to requestContext.method,
            "count" to count
        )

        recentRequests[clientIp] = requestOptions
        println(recentRequests[clientIp])
        return recentRequests[clientIp]
    }

    fun isAfterLastRequestedAt(lastRequestedAt: LocalTime, comparedSeconds: Long): Boolean {
        val comparedTime = LocalTime.now().minusSeconds(comparedSeconds)
        return lastRequestedAt.isAfter(comparedTime)
    }
}