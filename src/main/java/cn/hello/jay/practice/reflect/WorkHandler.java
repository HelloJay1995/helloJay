package cn.hello.jay.practice.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 周健以
 * @Date 2020年03月12日
 */
public class WorkHandler implements InvocationHandler {

    // 代理类中的真实对象
    private Object obj;

    public WorkHandler() {
    }

    // 构造函数，给我们的真实对象赋值
    public WorkHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object invoke = method.invoke(obj, args);
        System.out.println("after invoke");
        return invoke;
    }
}
