package com.oyhp.demo.jacoco.service;

import com.oyhp.demo.jacoco.mapper.MyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * XXXX
 *
 * @author OuYangHaiPing<OuYanghp @ pvc123.com>
 * @date 2020-07-03
 */
@Service
public class MyService {
    private MyDao myDao;
    private Logger logger;


    @Autowired
    public MyService(MyDao myDao, Logger logger) {
        this.myDao = myDao;
        this.logger = logger;
    }

    public int add(int x, int y){
        return myDao.add(x, y);
    }
}
