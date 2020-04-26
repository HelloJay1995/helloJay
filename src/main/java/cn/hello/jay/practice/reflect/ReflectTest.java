package cn.hello.jay.practice.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author 周健以
 * @Date 2020年03月12日
 */
public class ReflectTest {

    public static void mainReplace(String[] args) {
        // 要代理的真实对象
        People people = new Teacher();
        // 代理对象的调用程序，我们将要代理的真实对象传入代理对象的调用处理的构造函数中，最终代理对象的调用处理程序会调用真实对象的方法
        InvocationHandler handler = new WorkHandler(people);
        /**
         * 通过Proxy类的newProxyInstance方法创建代理对象
         * 使用handler对象的classloader对象来加载我们的代理对象
         * 这里为代理类提供的接口是真实对象实现的接口，这样代理对象就能像真实对象一样调用接口中的所有方法
         * 将代理对象关联到上面的InvocationHandler对象上
         */
        People proxy = (People) Proxy.newProxyInstance(handler.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);
        System.out.println(proxy.work());
    }
}
