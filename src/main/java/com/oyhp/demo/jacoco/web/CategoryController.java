package com.oyhp.demo.jacoco.web;

import com.oyhp.demo.jacoco.model.Category;
import com.oyhp.demo.jacoco.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * XXXX
 *
 * @author OuYangHaiPing<OuYanghp @ pvc123.com>
 * @date 2020-07-07
 */
@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("list")
    public List<Category> listAll(){
        return categoryService.fillAll();
    }
}
