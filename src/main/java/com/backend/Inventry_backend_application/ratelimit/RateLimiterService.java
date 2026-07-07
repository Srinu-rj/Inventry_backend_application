//package com.backend.Inventry_backend_application.ratelimit;
//
//
//import io.github.bucket4j.Bandwidth;
//import io.github.bucket4j.Bucket;
//import org.springframework.stereotype.Service;
//
//import java.time.Duration;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Service
//public class RateLimiterService  {
//
//    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();
//
//    public Bucket resolveBucket(String key) {
//        return buckets.computeIfAbsent(key, k -> {
//            // Allow 100 requests per minute
//            Bandwidth limit = Bandwidth.builder()
//                    .capacity(100)
//                    .refillGreedy(100, Duration.ofMinutes(1))
//                    .build();
//            return Bucket.builder().addLimit(limit).build();
//        });
//    }
//}
