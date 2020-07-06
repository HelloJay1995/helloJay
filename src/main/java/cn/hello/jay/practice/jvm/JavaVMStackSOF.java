package cn.hello.jay.practice.jvm;

/**
 * @author 周健以
 * @Date 2020年06月22日
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF test = new JavaVMStackSOF();
        try {
            test.stackLeak();
        } catch (Throwable e) {
            System.out.println("stackLength:" + test.stackLength);
            throw e;
        }
    }
}
