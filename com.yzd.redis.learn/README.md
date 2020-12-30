## redis benchmark

## 执行
```
java -cp com.yzd.redis.learn-1.0-SNAPSHOT.jar com.yzd.Application

```

## 性能
- 环境
    ```
  pika-linux-x86_64-v3.3.6.tar.bz2
  CentOS Linux 7.5.1804 64bit  CPU:8-core MEM:16G
  //
  Benchmark client: thread 30 
  Benchmark                           Mode  Cnt   Score   Error   Units
  JRedisClientRunner.jedisSimpleGet  thrpt       54.101          ops/ms
  JRedisClientRunner.jedisSimpleSet  thrpt       55.199          ops/ms
  ```

## 参考：
- []()
- []()
- []()