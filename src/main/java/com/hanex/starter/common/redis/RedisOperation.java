package com.hanex.starter.common.redis;

import org.springframework.data.redis.core.RedisOperations;

import java.time.Duration;

/**
 * Redis Interface  정의
 * @param <T>
 */
public interface RedisOperation<T> {

    Long count(RedisOperations<String, Object> operations, T t);

    Long add(RedisOperations<String, Object> operations, T t);

    Long remove(RedisOperations<String, Object> operations, T t);

    Boolean delete(RedisOperations<String, Object> operations, T t);

    Boolean expire(RedisOperations<String, Object> operations, T t, Duration duration);

    String generateValue(T t);

    void execute(RedisOperations<String, Object> operations, T t);
}
