package com.oyhp.demo.jacoco.model;

/**
 * 商品分类
 * @author OuYangHaiPing<OuYanghp@pvc123.com>
 * @date ${YEAR}-${MONTH}-${DAY}
 */
public class Category {
  
    private int id;
      
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
      
}