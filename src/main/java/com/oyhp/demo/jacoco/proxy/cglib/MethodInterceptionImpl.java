package com.oyhp.demo.jacoco.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author OuYangHaiPing<ouyanghaiping @ pvc123.com>
 * @date 2020-08-06
 */
public class MethodInterceptionImpl implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 表演开始收钱
        getMoney();
        // 明星开始唱歌
        Object invoke = methodProxy.invokeSuper(o, objects);
        // 表演结束后开发票
        writeReceipt();
        return invoke;
    }

    private void getMoney() {
        System.out.println("get money");
    }

    private void writeReceipt(){
        System.out.println("write receipt");
    }


}
