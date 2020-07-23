package com.oyhp.demo.jacoco.service;

import com.oyhp.demo.jacoco.mapper.CategoryMapper;
import com.oyhp.demo.jacoco.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * XXXX
 *
 * @author OuYangHaiPing<OuYanghp @ pvc123.com>
 * @date 2020-07-07
 */
public interface CategoryService {
    /**
     * 所有商品分类
     * @return
     */
     List<Category> fillAll();

    /**
     * 添加商品分类
     * @param category
     */
    void add(Category category);
}
