package com.gyulbe.ekan_blog.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class CheckLastSubmitTimeAspect {
    @Around("@annotation(CheckLastSubmitTime)")
    @Throws(Throwable::class)
    fun checkLastSubmitTime(joinPoint: ProceedingJoinPoint): Any? {
        val start = System.currentTimeMillis()

        println("before start")
        val proceed = joinPoint.proceed()
        val executionTime = System.currentTimeMillis() - start
        println(executionTime)
        return proceed
    }
}
