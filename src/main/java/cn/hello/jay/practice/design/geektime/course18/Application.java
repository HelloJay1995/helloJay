package cn.hello.jay.practice.design.geektime.course18;

/**
 * @author 周健以
 * @Date 2020年06月09日
 */
public class Application {

    private static ConfigSource configSource = new ZooKeeperConfigSource();
    private static final RedisConfig REDIS_CONFIG = new RedisConfig(configSource);
    private static final MysqlConfig MYSQL_CONFIG = new MysqlConfig(configSource);
    private static final KafkaConfig KAFKA_CONFIG = new KafkaConfig(configSource);

    public static void main(String[] args) {
        ScheduledUpdater redisUpdate = new ScheduledUpdater(10, 10, REDIS_CONFIG);
        redisUpdate.run();

        ScheduledUpdater mysqlUpdate = new ScheduledUpdater(0, 30, MYSQL_CONFIG);
        mysqlUpdate.run();
    }
}
