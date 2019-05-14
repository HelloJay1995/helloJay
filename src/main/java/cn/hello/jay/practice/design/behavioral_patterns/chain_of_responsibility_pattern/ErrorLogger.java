package cn.hello.jay.practice.design.behavioral_patterns.chain_of_responsibility_pattern;

/**
 * 2. 创建扩展了该记录器类的实体类
 *
 * @author 周健以
 * @Date 2019年03月27日
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Error::Logger: " + message);
    }
}
