package com.gyulbe.ekan_blog.aspect

import com.gyulbe.ekan_blog.domain.post.RecentRequestHandler
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import kotlin.reflect.typeOf


@Aspect
@Component
class CheckRecentSubmitTimeAspect(
    private val recentRequestHandler: RecentRequestHandler
) {
    @Throws(Throwable::class)
    @Around("@annotation(com.gyulbe.ekan_blog.annotation.CheckRecentSubmitTime)")
    fun checkLastSubmitTime(joinPoint: ProceedingJoinPoint): Any? {
        val requestContext = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request
        val count = recentRequestHandler.handleRecentRequestInfo(requestContext)?.get("count") as Int
        val proceed = joinPoint.proceed()
        if(count < 5) return proceed

        return "too many requests"
    }
}
