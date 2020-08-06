package com.oyhp.demo.jacoco.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * @author OuYangHaiPing<ouyanghaiping @ pvc123.com>
 * @date 2020-08-06
 */
public class JDKProxyDemo {
    public static void main(String[] args) {
        // 1、创建被代理的具体类
        Star star = new Star("Djm");
        // 2、获取对应的ClassLoader
        ClassLoader classLoader = star.getClass().getClassLoader();
        // 3、获取被代理对象实现的所有接口
        Class[] interfaces = star.getClass().getInterfaces();
        // 4、设置请求处理器，处理所有方法调用
        InvocationHandler invocationHandler = new InvocationHandlerImpl(star);
        /**
         * 5.根据上面提供的信息，创建代理对象 在这个过程中，
         *   a.JDK会通过根据传入的参数信息动态地在内存中创建和.class文件等同的字节码
         *   b.然后根据相应的字节码转换成对应的class，
         *   c.然后调用newInstance()创建实例
         */
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        ShowService starProxy = (ShowService) proxy;
        starProxy.sing("MockingBird");
    }
}
