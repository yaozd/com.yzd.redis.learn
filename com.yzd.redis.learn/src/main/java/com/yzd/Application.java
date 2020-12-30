package com.yzd;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @Author: yaozh
 * @Description:
 */
public class Application {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(JRedisClientRunner.class.getSimpleName())
                //.output("redis-throughput.log")
                //.forks(0)
                .build();
        new Runner(options).run();
    }
}
