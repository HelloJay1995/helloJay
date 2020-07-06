package cn.hello.jay.practice.design.geektime.course18;

/**
 * @author 周健以
 * @Date 2020年06月09日
 */
public class MysqlConfig implements Updater {

    private ConfigSource configSource;

    public MysqlConfig(ConfigSource configSource) {
        this.configSource = configSource;
    }

    @Override
    public void update() {

    }
}
