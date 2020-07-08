package com.oyhp.demo.jacoco.mapper;

import com.oyhp.demo.jacoco.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * XXXX
 *
 * @author OuYangHaiPing<OuYanghp @ pvc123.com>
 * @date 2020-07-07
 */
@Mapper
public interface CategoryMapper {

    /**
     * 查询所有商品分类
     * @return
     */
    List<Category> findAll();

}
