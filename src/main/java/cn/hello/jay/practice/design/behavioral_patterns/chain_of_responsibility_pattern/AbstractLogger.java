package cn.hello.jay.practice.design.behavioral_patterns.chain_of_responsibility_pattern;

/**
 * 1.创建抽象的记录器类
 *
 * @author 周健以
 * @Date 2019年03月27日
 */
public abstract class AbstractLogger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    protected int level;
    /**
     * 责任链的下一个元素
     */
    protected AbstractLogger nextAbstractLogger;

    /**
     * 写消息
     *
     * @param message
     */
    protected abstract void write(String message);

    /**
     * 打印信息
     */
    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextAbstractLogger != null) {
            nextAbstractLogger.logMessage(level, message);
        }
    }

    public void setNextAbstractLogger(AbstractLogger nextAbstractLogger) {
        this.nextAbstractLogger = nextAbstractLogger;
    }

}
