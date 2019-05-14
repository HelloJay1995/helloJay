package cn.hello.jay.practice.design.behavioral_patterns.chain_of_responsibility_pattern;

/**
 * 3. 创建不同类型的记录器。赋予它们不同的错误级别，并在每个记录器中设置下一个记录。每个记录器中的下一个记录代码是链的一部分。
 *
 * @author 周健以
 * @Date 2019年03月27日
 */
public class MainTest {
//    public static void main(String[] args) {
//        AbstractLogger loggerChain = getChainOfLoggers();
//        loggerChain.logMessage(AbstractLogger.INFO,
//                "This is an information.");
//
//        loggerChain.logMessage(AbstractLogger.DEBUG,
//                "This is an debug level information.");
//
//        loggerChain.logMessage(AbstractLogger.ERROR,
//                "This is an error information.");
//    }

    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger debugLogger = new ErrorLogger(AbstractLogger.DEBUG);
        AbstractLogger infoLogger = new ErrorLogger(AbstractLogger.INFO);

        errorLogger.setNextAbstractLogger(debugLogger);
        debugLogger.setNextAbstractLogger(infoLogger);

        return errorLogger;
    }
}
