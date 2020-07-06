package cn.hello.jay.practice.reflect;

import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import java.lang.reflect.Method;

/**
 * @author 周健以
 * @Date 2020年06月19日
 */
public class VarTest {
    public static void main(String[] args) throws NotFoundException {
        VarDemo demo = new VarDemo();
        Method[] methods = demo.getClass().getDeclaredMethods();
        Class clazz = methods[0].getDeclaringClass();
        String methodName = methods[0].getName();
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(new ClassClassPath(clazz));
        CtClass cc = pool.get(clazz.getName());
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr =
                (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            System.out.println("params is null");
        }
        String[] paramNames = new String[cm.getParameterTypes().length];
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < paramNames.length; i++)
            paramNames[i] = attr.variableName(i + pos);
        for (int i = 0; i < paramNames.length; i++) {
            System.out.println(paramNames[i]);
        }
    }
}
