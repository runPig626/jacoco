package com.oyhp.demo.jacoco.service;

import com.oyhp.demo.jacoco.mapper.CategoryMapper;
import com.oyhp.demo.jacoco.model.Category;
import com.oyhp.demo.jacoco.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
/**
 * @author OuYangHaiPing<ouyanghaiping @ pvc123.com>
 * @date 2020-08-03
 */
@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    @Mock
    private Category category;
    @Mock
    private CategoryMapper categoryMapper;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void test_findAll(){
        Mockito.when(categoryMapper.findAll()).thenReturn(Arrays.asList(new Category(), new Category()));
        Assertions.assertEquals(2, categoryService.fillAll().size());
    }

    @Test
    void test_dooAdd_fail(){
        Mockito.when(categoryMapper.add(category)).thenReturn(-1);
        Assertions.assertDoesNotThrow(()->categoryService.doAdd(category));
    }

}
