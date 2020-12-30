package com.yzd;

import com.yzd.util.DataUtil;
import org.openjdk.jmh.annotations.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yaozh
 * @Description:
 */
@Fork(1)
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
        jedis = newJedis();
    }

    private Jedis newJedis() {
        String redisHost = "172.20.132.85";
        int redisPort = 9221;
        return new Jedis(redisHost, redisPort, 60);
    }

    @Param({"1024", "5120", "102400","1048576"})
    private int dataSize;

    @Benchmark
    public String jedisSimpleSet() {
        jedisSetCount++;
        String result = null;
        try {
            result = jedis.set(getFormatKey(jedisSetCount), DataUtil.getCacheMockData(dataSize));
        } catch (JedisConnectionException ex) {
            jedis = newJedis();
        }
        return result;
    }

//    @Benchmark
//    public String jedisSimpleGet() {
//        jedisGetCount++;
//        String result = null;
//        result = jedis.get(getFormatKey(jedisGetCount));
//        return result;
//    }

    private String getFormatKey(Integer count) {
        return String.format("JedisSetTest%s", count);
    }
}

