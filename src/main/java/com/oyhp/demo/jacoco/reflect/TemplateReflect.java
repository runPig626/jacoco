package com.oyhp.demo.jacoco.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * @author OuYangHaiPing<ouyanghaiping @ pvc123.com>
 * @date 2020-08-05
 */
public class TemplateReflect<T> extends AbstracTemplateReflect<T>{
    private Class<T> clazz;

    public TemplateReflect(){
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    @Override
    public void add(String param) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Method addMethod = clazz.getMethod("add", String.class);
        addMethod.invoke(clazz, param);
    }
}
