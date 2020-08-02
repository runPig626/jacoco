package com.oyhp.demo.jacoco.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author OuYangHaiPing<ouyanghaiping @ pvc123.com>
 * @date 2020-07-24
 */
public class Product {
    private int id;
    private String productName;

    public Product(Integer id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public static void main(String[] args) {
//        Class clazz = Product.class;
//        try {
//            Constructor constructor = clazz.getConstructor(Integer.class, String.class);
//            Product product = (Product) constructor.newInstance(1,"jiaMin");
//            System.out.println("product = " + product);
//        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Product product = (Product) context.getBean("product");
        System.out.println(product);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
