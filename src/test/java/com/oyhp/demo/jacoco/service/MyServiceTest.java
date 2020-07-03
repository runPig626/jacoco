package com.oyhp.demo.jacoco.service;

import com.oyhp.demo.jacoco.mapper.MyDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.logging.Logger;

/**
 * XXXX
 *
 * @author OuYangHaiPing<OuYanghp @ pvc123.com>
 * @date 2020-07-03
 */
class MyServiceTest {
    private MyDao mockDao = Mockito.mock(MyDao.class);
    private MyService myService;
    private Logger mockLogger = Mockito.mock(Logger.class);

    MyServiceTest() {
        // 单元测试通过Mockito.mock来模拟一个类的实现
        myService = new MyService(mockDao, mockLogger);
    }

    // @Disabled 忽略测试
    @ParameterizedTest(name = "测试添加成功")
    @CsvSource({"2, 2, 4, 4"})
    void add_test_success(int x, int y, int result, int expectedResult) {
        // 假设当前系统是Mac
        Assumptions.assumeTrue(System.getProperty("os.name").contains("Windows"));
        // Mockito什么都没有，除非开发者为它自定义开发功能
        Mockito.when(mockDao.add(x, y)).thenReturn(result);
        // 断言是最基本测试的形态
        Assertions.assertEquals(expectedResult, myService.add(x,y));
    }

    @ParameterizedTest
    @CsvSource({"2, 2"})
    void add_test_exception(int x, int y){
        // Mockito.anyX无论传进任何值都会抛出异常
        // Mockito.when(mockDao.add(Mockito.anyInt(), Mockito.anyInt())).thenThrow(new ArithmeticException());
        // thenAnswer可以做独特的行为
        Mockito.when(mockDao.add(Mockito.anyInt(), Mockito.anyInt())).thenAnswer(invocationOnMock -> {
            System.out.println("我被调用了");
            throw new ArithmeticException("不合法运算");
        });
        // 断言是最基本测试的形态
        Assertions.assertThrows(ArithmeticException.class, ()-> myService.add(x, y));
        // verify确保X函数是否被使用，ArgumentCaptor可以抓准运行结果，从而断言
//        Mockito.verify(mockLogger).warning("mockLogger未被使用过一次");
    }

}