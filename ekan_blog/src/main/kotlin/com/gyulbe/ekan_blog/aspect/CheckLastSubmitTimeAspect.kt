package com.gyulbe.ekan_blog.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes


@Aspect
@Component
class CheckLastSubmitTimeAspect {

    @Throws(Throwable::class)
    @Around("@annotation(com.gyulbe.ekan_blog.annotation.CheckLastSubmitTime)")
    fun checkLastSubmitTime(joinPoint: ProceedingJoinPoint): Any? {
        val request = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request
        val url = request.requestURL
        val method = request.method

        println(url)
        println(method)
        val proceed = joinPoint.proceed()
        println("after start")
        return proceed
    }
}
