//package com.backend.Inventry_backend_application.ratelimit;
//
//import io.github.bucket4j.Bandwidth;
//import io.github.bucket4j.BucketConfiguration;
//import io.github.bucket4j.distributed.ExpirationAfterWriteStrategy;
//import io.github.bucket4j.distributed.proxy.ProxyManager;
//import io.github.bucket4j.redis.lettuce.Bucket4jLettuce;
//import io.lettuce.core.RedisClient;
//import io.lettuce.core.api.StatefulRedisConnection;
//import io.lettuce.core.codec.ByteArrayCodec;
//import io.lettuce.core.codec.RedisCodec;
//import io.lettuce.core.codec.StringCodec;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.Duration;
//
//@Service
//@RequiredArgsConstructor
//public class DistributedRateLimiterService {
//    private ProxyManager proxyManager;
//
//    @PostConstruct
//    public void init() {
//        RedisClient redisClient = RedisClient.create("redis://localhost:6379");
//        StatefulRedisConnection connection = redisClient.connect(
//                RedisCodec.of(StringCodec.UTF8, ByteArrayCodec.INSTANCE));
//
//        proxyManager = Bucket4jLettuce.casBasedBuilder(connection)
//                .expirationAfterWrite(
//                        ExpirationAfterWriteStrategy.basedOnTimeForRefillingBucketUpToMax(
//                                Duration.ofMinutes(5)))
//                .build();
//    }
//
//    public boolean tryConsume(String key, int requestsPerMinute) {
//        return proxyManager
//                .getProxy(key, () -> BucketConfiguration.builder()
//                        .addLimit(Bandwidth.builder()
//                                .capacity(requestsPerMinute)
//                                .refillGreedy(requestsPerMinute, Duration.ofMinutes(1))
//                                .build())
//                        .build())
//                .tryConsume(1);
//    }
//}
