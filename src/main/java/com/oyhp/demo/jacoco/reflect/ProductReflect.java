package com.oyhp.demo.jacoco.reflect;

import com.oyhp.demo.jacoco.model.Product;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射基本使用，构造器，方法，字段
 * @author OuYangHaiPing<ouyanghaiping @ pvc123.com>
 * @date 2020-08-05
 */
public class ProductReflect {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Product.class;
        // 获取有参构造器
        Constructor constructor = clazz.getConstructor(Integer.class, String.class);
        // 获取该类的对象并设置属性的值
        Object obj = constructor.newInstance(1, "djm");

        // 获取类的全类名，即包含路径
        String fullClassName = clazz.getName();

        // 获取类名
        String className = clazz.getSimpleName();

        // 获取类中公共类型（public）的属性
        Field[] fields = clazz.getFields();
        String fieldName;
        System.out.println("public fields of object");
        for (Field field : fields) {
            //获取属性名
            fieldName = field.getName();
            System.out.println(fieldName);
        }

        System.out.println("all fields of object");
        // 获取类中全部类型属性(包含private)
        Field[] fieldAll = clazz.getDeclaredFields();
        for (Field field : fieldAll) {
            // 获取属性名
            fieldName = field.getName();
            System.out.println(fieldName);
        }

        // 获取指定公共属性
        Field shareId_Field = clazz.getField("shareId");
        Object shareIdValue = shareId_Field.get(obj);
        System.out.println("公共指定属性值 " + shareIdValue);

        // 获取指定私有属性
        Field id_Field = clazz.getDeclaredField("id");
        id_Field.setAccessible(true);
        Object idValue = id_Field.get(obj);
        System.out.println("私有指定属性值: " + idValue);

        // 获取该类中的公共方法
        Method[] methods = clazz.getMethods();
        String methodName;
        for (Method method : methods) {
            methodName = method.getName();
            System.out.println("公共方法" + methodName);
        }

        // 获取该类中所有方法（包含private）
        Method[] methodAll = clazz.getDeclaredMethods();
        for (Method method : methodAll) {
            methodName = method.getName();
            System.out.println("所有方法" + methodName);
        }

        // 获取并使用指定方法
        Method setProductNameMethod = clazz.getMethod("setProductName", String.class);
        setProductNameMethod.invoke(obj, "OYHP");

        Method getProductNameMethod = clazz.getMethod("getProductName");
        String productName = (String) getProductNameMethod.invoke(obj);
        System.out.println(productName);

        // 获取实例
        Product product = (Product) constructor.newInstance(2, "oyhp");
        System.out.println(product);
    }
}
