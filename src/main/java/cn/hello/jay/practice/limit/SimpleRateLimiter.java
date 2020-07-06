package cn.hello.jay.practice.limit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author 周健以
 * @Date 2020年04月09日
 */
@Component
public class SimpleRateLimiter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public boolean rateLimit(String key, int max, int rate) {
        List<String> keyList = new ArrayList<>(1);
        keyList.add(key);
        return "1".equals(stringRedisTemplate
                                  .execute(new RedisRateLimitScript(), keyList, Integer.toString(max), Integer.toString(rate),
                                          Long.toString(System.currentTimeMillis())));
    }
}
