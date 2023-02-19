package com.gyulbe.ekan_blog.aspect

import com.gyulbe.ekan_blog.domain.post.CheckRecentSubmitTimeHandler
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes


@Aspect
@Component
class CheckRecentSubmitTimeAspect(
    private val checkRecentSubmitTimeHandler: CheckRecentSubmitTimeHandler
) {
    @Throws(Throwable::class)
    @Around("@annotation(com.gyulbe.ekan_blog.annotation.CheckLastSubmitTime)")
    fun checkLastSubmitTime(joinPoint: ProceedingJoinPoint): Any? {
        val recentRequests = checkRecentSubmitTimeHandler.recentRequests
        val requestContext = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request
        val clientIp = requestContext.remoteAddr
        var count = 0

        println("count: ${recentRequests[clientIp]?.get("count")}")
        if (recentRequests[clientIp]?.get("count") != null) {
            count = recentRequests[clientIp]?.get("count") as Int + 1
        }

        println(count)

        val requestOptions = mapOf<String, Any>(
            "requestUrl" to requestContext.requestURL,
            "method" to requestContext.method,
            "count" to count
        )

        recentRequests[clientIp] = requestOptions

        println(recentRequests[clientIp])

        val proceed = joinPoint.proceed()
        println("after call")
        return proceed
    }
}
