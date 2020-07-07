package com.oyhp.demo.jacoco.service.impl;

import com.oyhp.demo.jacoco.mapper.CategoryMapper;
import com.oyhp.demo.jacoco.model.Category;
import com.oyhp.demo.jacoco.service.CategoryService;
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
@Service
public class CategoryServiceImpl implements CategoryService{

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public List<Category> fillAll() {
        return categoryMapper.findAll();
    }

}
