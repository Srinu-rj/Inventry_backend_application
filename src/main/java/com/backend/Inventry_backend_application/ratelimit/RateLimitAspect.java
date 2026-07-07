//package com.backend.Inventry_backend_application.ratelimit;
//
//import io.github.bucket4j.Bandwidth;
//import io.github.bucket4j.Bucket;
//import jakarta.servlet.http.HttpServletRequest;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.time.Duration;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Aspect
//@Component
//public class RateLimitAspect {
//    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();
//
//    @Around("@annotation(rateLimit)")
//    public Object enforceRateLimit(ProceedingJoinPoint joinPoint, RateLimit rateLimit) throws Throwable {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
//                .currentRequestAttributes()).getRequest();
//        String key = joinPoint.getSignature().toShortString() + ":" + request.getRemoteAddr();
//
//        Bucket bucket = buckets.computeIfAbsent(key, k -> {
//            Bandwidth limit = Bandwidth.builder()
//                    .capacity(rateLimit.requests())
//                    .refillGreedy(rateLimit.requests(), Duration.ofMinutes(rateLimit.durationMinutes()))
//                    .build();
//            return Bucket.builder().addLimit(limit).build();
//        });
//
//        if (bucket.tryConsume(1)) {
//            return joinPoint.proceed();
//        }
//        throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "Rate limit exceeded");
//    }
//}
