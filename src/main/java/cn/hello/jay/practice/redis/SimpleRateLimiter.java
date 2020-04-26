package cn.hello.jay.practice.redis;

import redis.clients.jedis.Jedis;


/**
 * @author 周健以
 * @Date 2020年04月09日
 */
public class SimpleRateLimiter {
    private Jedis jedis;

    public SimpleRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) {
        String key = String.format("hist:%s:%s", userId, actionKey);
        return true;
    }

    public static void mainReplace(String[] args) {
        Jedis jedis = new Jedis();
        SimpleRateLimiter limiter = new SimpleRateLimiter(jedis);
        for (int i = 0; i < 20; i++) {
            System.out.println(limiter.isActionAllowed("laoqian", "reply", 60, 5));
        }
    }
}
