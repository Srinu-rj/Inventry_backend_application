//package com.backend.Inventry_backend_application.ratelimit;
//
//import io.github.bucket4j.Bucket;
//import io.github.bucket4j.ConsumptionProbe;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
////TODO In-memory implementations using Bucket4j utilize the Token Bucket algorithm.
//@Component
//public class RateLimitInterceptor implements HandlerInterceptor {
//    private final RateLimiterService rateLimiterService;
//
//    public RateLimitInterceptor(RateLimiterService rateLimiterService) {
//        this.rateLimiterService = rateLimiterService;
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response,
//                             Object handler) throws Exception {
//        String clientId = request.getRemoteAddr();
//        Bucket bucket = rateLimiterService.resolveBucket(clientId);
//
//        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
//        if (probe.isConsumed()) {
//            response.addHeader("X-Rate-Limit-Remaining",
//                    String.valueOf(probe.getRemainingTokens()));
//            return true;
//        }
//
//        response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
//        response.setContentType("application/json");
//        response.getWriter().write("{\"error\": \"Rate limit exceeded\"}");
//        return false;
//    }
//}
