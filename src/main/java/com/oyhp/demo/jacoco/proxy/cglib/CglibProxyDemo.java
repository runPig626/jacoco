package com.oyhp.demo.jacoco.proxy.cglib;

import com.oyhp.demo.jacoco.proxy.jdk.Star;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author OuYangHaiPing<ouyanghaiping @ pvc123.com>
 * @date 2020-08-06
 */
public class CglibProxyDemo {
    public static void main(String[] args) {
        Star star = new Star("Djm");
        // 方法拦截器，在我看来就是加强规则，告诉Cglib要如何加强
        MethodInterceptor methodInterceptor = new MethodInterceptionImpl();
        // Cglib中加强器，用来创建代理
        Enhancer enhancer = new Enhancer();
        // 设置要创建动态代理类
        enhancer.setSuperclass(star.getClass());
        /**
         * 设置回调，这里相当于是对于代理类上所有方法的调用，
         * 都会调用callback，而callback则需要执行intercept()方法进行拦截
         */
        enhancer.setCallback(methodInterceptor);

        Star proxy = (Star) enhancer.create();
        proxy.dance();
    }
}
