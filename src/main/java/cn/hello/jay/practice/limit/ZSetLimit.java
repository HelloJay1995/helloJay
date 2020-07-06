package cn.hello.jay.practice.limit;

import redis.clients.jedis.Jedis;

/**
 * @author 周健以
 * @Date 2020年06月28日
 */
public class ZSetLimit {

    private Jedis jedis;

    private ZSetLimit(Jedis jedis) {
        this.jedis = jedis;
    }

    /**
     * @param key      redis key
     * @param period   时间长度,单位秒
     * @param maxCount 最多次数
     * @return 允许用户行为：true  否则 false
     */
    private boolean isActionAllowed(String key, int period, int maxCount) {
        long nowTs = System.currentTimeMillis();
        double min = 0;
        double max = nowTs - period * 1000;
        // 移除时间窗口之前的行为记录，剩下的都是时间窗口内的
        jedis.zremrangeByScore(key, min, max);
        // 获取窗口内的行为数量
        long count = jedis.zcard(key);
        boolean isAllow = count < maxCount;
        if (isAllow) {
            // key  userId + actionKey
            // score 访问时间
            // member  无特殊意义，只要保证唯一就可以了
            jedis.zadd(key, nowTs, String.valueOf(nowTs));
            // 设置 zset 过期时间，避免冷用户持续占用内存
            // 过期时间应该等于时间窗口的长度
            jedis.expire(key, period);
        }
        return isAllow;
    }

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.connect();
        ZSetLimit limiter = new ZSetLimit(jedis);
        String actionKey = "reply";
        int period = 3;
        int maxCount = 2;
        for (int i = 0; i < 10; i++) {
            System.out.println(limiter.isActionAllowed(actionKey, period, maxCount));
            Thread.sleep(1000);
        }
    }
}
