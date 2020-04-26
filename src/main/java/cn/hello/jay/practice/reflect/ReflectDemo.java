package cn.hello.jay.practice.reflect;

import java.lang.reflect.Method;

public class ReflectDemo {

    public static void mainReplace(String[] args) throws Exception {
        Class<?> clazz = Class.forName("cn.hello.jay.practice.reflect.ReflectDemo");
        Object instance = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("print");
//        Method method = clazz.getMethod("print");
        method.invoke(instance);
    }

    private void print() {
        System.out.println("hello Jay");
    }
}
