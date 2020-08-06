package com.oyhp.demo.jacoco.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * @author OuYangHaiPing<ouyanghaiping @ pvc123.com>
 * @date 2020-08-06
 */
public abstract class AbstracTemplateReflect<T> {
    public abstract void add(String params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
