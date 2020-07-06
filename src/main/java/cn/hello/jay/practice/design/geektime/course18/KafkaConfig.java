package cn.hello.jay.practice.design.geektime.course18;

/**
 * @author 周健以
 * @Date 2020年06月09日
 */
public class KafkaConfig implements Updater {

    private ConfigSource configSource;

    public KafkaConfig(ConfigSource configSource) {
        this.configSource = configSource;
    }

    @Override
    public void update() {

    }
}
