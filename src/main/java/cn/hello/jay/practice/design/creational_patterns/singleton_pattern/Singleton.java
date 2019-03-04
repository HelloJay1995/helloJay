/**
 *
 */
package cn.hello.jay.practice.design.creational_patterns.singleton_pattern;


/**
 * @author 周健以
 * @Date 2019年02月22日
 */
public class Singleton {
    private static Singleton singleton = null;
    private static Singleton singleton3 = new Singleton(); //饿汉模式

    private Singleton() {
    }

    /**
     * 线程不安全
     */
    public static Singleton getInstance1() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    /**
     * 获取单例--必须加锁 synchronized 才能保证单例，但加锁会影响效率
     */
    public static synchronized Singleton getInstance2() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    /**
     * 饿汉式，线程安全
     */
    public static Singleton getInstance3() {
        return singleton3;
    }

    /**
     * 双重校验锁模式，线程安全
     */
    public static Singleton getInstance4() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 登记式/静态内部类
     */
    public static Singleton getInstance5() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    /**
     * 枚举--实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化。
     */
    public enum Singleton6 {
        INSTANCE;

        private Singleton6() {
        }
    }

}
