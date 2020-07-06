package cn.hello.jay.practice.design.geektime.course18;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 周健以
 * @Date 2020年06月09日
 */
public class ScheduledUpdater {
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private long initDelayInSeconds;
    private long periodInSeconds;

    private Updater updater;

    public ScheduledUpdater(long initDelayInSeconds, long periodInSeconds, Updater updater) {
        this.initDelayInSeconds = initDelayInSeconds;
        this.periodInSeconds = periodInSeconds;
        this.updater = updater;
    }

    public void run() {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                updater.update();
            }
        }, initDelayInSeconds, periodInSeconds, TimeUnit.SECONDS);
    }
}
