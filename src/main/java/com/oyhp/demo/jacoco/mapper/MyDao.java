package com.oyhp.demo.jacoco.mapper;

import org.springframework.stereotype.Component;

/**
 * XXXX
 *
 * @author OuYangHaiPing<OuYanghp @ pvc123.com>
 * @date 2020-07-03
 */
@Component
public interface MyDao {
    /**
     * 计算结果
     * @param x
     * @param y
     * @return
     */
    int add(int x, int y);
}
