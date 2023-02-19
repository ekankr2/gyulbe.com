package com.gyulbe.ekan_blog.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.concurrent.ConcurrentHashMap


@Aspect
@Component
class CheckLastSubmitTimeAspect {

    @Throws(Throwable::class)
    @Around("@annotation(com.gyulbe.ekan_blog.annotation.CheckLastSubmitTime)")
    fun checkLastSubmitTime(joinPoint: ProceedingJoinPoint): Any? {
        val recentRequests: ConcurrentHashMap<String, Any> = ConcurrentHashMap()
        val request = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request
        val clientIp = request.remoteAddr
        val requestOptions = mapOf("requestUrl" to request.requestURL, "method" to request.method)

        recentRequests[clientIp] = requestOptions

        println(recentRequests[clientIp])

        val proceed = joinPoint.proceed()
        println("after call")
        return proceed
    }
}
