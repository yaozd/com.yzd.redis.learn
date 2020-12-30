package com.yzd;

import org.openjdk.jmh.annotations.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yaozh
 * @Description:
 */
@BenchmarkMode({Mode.Throughput})
@Warmup(iterations = 1)
@Threads(30)
@State(Scope.Thread)
@Measurement(iterations = 1, time = 60_000, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JRedisClientRunner {
    private JedisCommands jedis;
    private static Integer jedisGetCount = 0;
    private static Integer jedisSetCount = 0;

    @Setup
    public void setup() {
        //String redisHost = "192.168.56.104";
        //int redisPort = 6379;
        String redisHost = "172.20.132.85";
        int redisPort = 9221;
        jedis = new Jedis(redisHost, redisPort);
    }

    @Benchmark
    public String jedisSimpleSet() {
        jedisSetCount++;
        String result = null;
        result = jedis.set(getFormatKey(jedisSetCount), jedisSetCount.toString());
        return result;
    }

    @Benchmark
    public String jedisSimpleGet() {
        jedisGetCount++;
        String result = null;
        result = jedis.get(getFormatKey(jedisGetCount));
        return result;
    }

    private String getFormatKey(Integer count) {
        return String.format("JedisSetTest%s", count);
    }
}

