package com.oyhp.demo.jacoco.service;

import com.oyhp.demo.jacoco.JacocoApplication;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * XXXX
 *
 * @author OuYangHaiPing<OuYanghp @ pvc123.com>
 * @date 2020-07-06
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JacocoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
class MyServiceIntegrationTest {
    @Autowired
    CategoryService categoryService;

    @BeforeEach
    public void setUp(){
        // 初始化内存数据库，以备测试
        ClassicConfiguration conf = new ClassicConfiguration();
        conf.setDataSource(
                "jdbc:h2:mem:test",
                "test",
                "test"
        );

        Flyway flyway = new Flyway(conf);
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void test(){
        categoryService.fillAll();
        System.out.println("categoryService = " + categoryService);
    }
}
