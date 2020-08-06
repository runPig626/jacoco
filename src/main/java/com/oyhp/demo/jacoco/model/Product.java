package com.oyhp.demo.jacoco.model;

import com.oyhp.demo.jacoco.reflect.ProductService;
import com.oyhp.demo.jacoco.reflect.TemplateReflect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * @author OuYangHaiPing<ouyanghaiping @ pvc123.com>
 * @date 2020-07-24
 */
public class Product extends TemplateReflect<Product>{
    public int shareId;
    public String shareName;
    private int id;
    private String productName;

    public Product(Integer id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public Product() {

    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ProductService service = new ProductService();
        service.add("bab");
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
