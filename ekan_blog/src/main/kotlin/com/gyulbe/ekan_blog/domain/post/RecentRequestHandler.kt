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
        val countFromLastRequest = recentRequests[clientIp]?.get("count") as? Int
        var count = 0

        if (lastRequestedAt != null && isBeforeLastRequestedTime(lastRequestedAt, 5)) {
            count = countFromLastRequest!! + 1
        }

        val requestOptions = mapOf<String, Any>(
            "lastRequestedAt" to calculateInputTimeFromCount(countFromLastRequest, 5),
            "requestUrl" to requestContext.requestURL,
            "method" to requestContext.method,
            "count" to count
        )

        recentRequests[clientIp] = requestOptions
        println(recentRequests[clientIp])
        return recentRequests[clientIp]
    }

    fun isBeforeLastRequestedTime(lastRequestedAt: LocalTime, comparedSeconds: Long): Boolean {
        val comparedTime = LocalTime.now().minusSeconds(comparedSeconds)
        return comparedTime.isBefore(lastRequestedAt)
    }

    private fun calculateInputTimeFromCount(countFromLastRequest: Int?, limitedCount: Int): LocalTime {
        if (countFromLastRequest != null && countFromLastRequest > limitedCount) {
            return LocalTime.now().plusMinutes(30)
        }
        return LocalTime.now()
    }

}